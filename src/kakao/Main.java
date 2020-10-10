package kakao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Main {
	static class Location{
		int id,located_bikes_count;
		int x,y;
		public Location() {
			super();
		}
		public Location(int id, int located_bikes_count, int x, int y) {
			super();
			this.id = id;
			this.located_bikes_count = located_bikes_count;
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Location [id=" + id + ", located_bikes_count=" + located_bikes_count + ", x=" + x + ", y=" + y
					+ "]";
		}
		
	}
	static class Truck{
		int id, loaded_bikes_count, location_id;
		int x,y,dist;
		public Truck(int id, int loaded_bikes_count, int location_id, int x, int y) {
			super();
			this.id = id;
			this.loaded_bikes_count = loaded_bikes_count;
			this.location_id = location_id;
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Truck [id=" + id + ", loaded_bikes_count=" + loaded_bikes_count + ", location_id=" + location_id
					+ ", x=" + x + ", y=" + y + "]";
		}
		
	}
	static class Command{
		int truck_id;
		List<Integer> commandList;
		public Command(int truck_id, List<Integer> commandList) {
			super();
			this.truck_id = truck_id;
			this.commandList = commandList;
		}
		@Override
		public String toString() {
			return "Command {truck_id=" + truck_id + ", commandList=" + commandList + "}";
		}
		
	}
	static int[] dx = {0,-1,0,1,0};
	static int[] dy = {0,0,1,0,-1};
	static int N, time;
	static int[] bef,befSend, befReceive;
	public static void main(String[] args) {
		String url = "https://pegkq2svv6.execute-api.ap-northeast-2.amazonaws.com/prod/users";
//		simulator1(url);
		simulator2(url);
	}
	

	private static void simulator1(String url) {
		String token = "e3eb1d07e4b46a075ab2dd81fc6358cc";
		JSONObject ret = start(url, token, "1");
		String auth_key = ret.getString("auth_key");
		
		for(int i = 0; i < 720; i++) {
			List<Location> locations = getLocation(locations(url, auth_key));
			Collections.sort(locations, (o1,o2)
					->(o1.located_bikes_count - o2.located_bikes_count));
			List<Truck> trucks = getTrucks(trucks(url, auth_key));
			List<Command> commandList = makeCommands1(locations, trucks,1,7);
			String commands = commTojsonArray(commandList).toString();
			if(i==719 || i%30==0)
				System.out.println(simulate(url,auth_key,commands));
			else simulate(url, auth_key, commands);
		}
		System.out.println(score(url,auth_key));
	}
	private static void simulator2(String url) {
		String token = "e3eb1d07e4b46a075ab2dd81fc6358cc";
		JSONObject ret = start(url, token, "2");
		String auth_key = ret.getString("auth_key");
		bef = new int[3600];
		befSend = new int[3600];
		befReceive = new int[3600];
		for(int i = 0; i < 720; i++) {
			List<Location> locations = getLocation(locations(url, auth_key));
			Collections.sort(locations, (o1,o2)
					->(o1.located_bikes_count - o2.located_bikes_count));
			List<Truck> trucks = getTrucks(trucks(url, auth_key));
			List<Command> commandList = makeCommands2(locations, trucks,3,20);
			String commands = commTojsonArray(commandList).toString();
			JSONObject simulate = simulate(url,auth_key,commands);
			time = simulate.getInt("time");
			System.out.println(simulate);
		}
		System.out.println(score(url,auth_key));
		
	}
	private static List<Command> makeCommands1(List<Location> locations, List<Truck> trucks,
												int bikeCnt, int loopCnt) {
		List<Command> ret = new ArrayList<>();
		for (Truck t : trucks) 
			ret.add(new Command(t.id, new ArrayList<>()));
		int locNum = locations.size(), cnt = 0;
		outer:
		for (Location loc : locations) {
			if(loc.located_bikes_count >= bikeCnt || cnt++ > loopCnt) break;
			// 남은 바이크가 0개일때만
			int truckCnt = 0, locCnt = 0;
			int max_located_bike = locations.get(locNum-1).located_bikes_count;
			for (int i = locNum-1; i > 0; i--) {
				if(max_located_bike > locations.get(i).located_bikes_count) break;
				locCnt++;
			}
			Location sendLoc = locations.get(locNum-locCnt);
			if(sendLoc.located_bikes_count == loc.located_bikes_count) {
				cnt--;
				continue;
			}
			for (Truck t : trucks)
				t.dist = getDistance(t.x, t.y, sendLoc.x, sendLoc.y);
			Collections.sort(trucks,(o1,o2)->(o1.dist-o2.dist==0?o1.id-o2.id:o1.dist-o2.dist));
			Truck truck = null;
			while((truck= trucks.get(truckCnt)).loaded_bikes_count >= 16) truckCnt++;
			Command comm = ret.get(truck.id);
			int moveSec = getDistance(sendLoc.x,sendLoc.y,truck.x,truck.y);
			int sendSec = getDistance(loc.x,loc.y,sendLoc.x,sendLoc.y);
			while(sendSec >= 8 - moveSec) {
				if(locNum-(++locCnt) < 0) {
					cnt--;
					continue outer;
				}
				sendLoc = locations.get(locNum-locCnt);
				moveSec = getDistance(sendLoc.x,sendLoc.y,truck.x,truck.y);
				sendSec = getDistance(loc.x,loc.y,sendLoc.x,sendLoc.y);
			};
			int loadBikeCount = (60 - comm.commandList.size() - (sendSec + moveSec)*6)/12;
			while(sendLoc.located_bikes_count/4 > loadBikeCount) loadBikeCount--;
			int loadBikeNum = loadBikeCount;
			if(loadBikeCount < 1) {
				cnt--;
				continue;
			}
			while(moveSec-- > 0) {
				int dir = move(truck.x,truck.y,sendLoc.x,sendLoc.y);
				comm.commandList.add(dir);
				truck.x += dx[dir];
				truck.y += dy[dir];
			}
			while(loadBikeCount-- > 0) {
				comm.commandList.add(5);
				truck.loaded_bikes_count++;
				if(truck.loaded_bikes_count >= 20) break;
			}
			while(sendSec-- > 0) {
				int dir = move(truck.x,truck.y,loc.x,loc.y);
				comm.commandList.add(dir);
				truck.x += dx[dir];
				truck.y += dy[dir];
			}
			while(loadBikeNum-- > loadBikeCount) {
				comm.commandList.add(6);
				truck.loaded_bikes_count--;
			}
		}
		return ret;
	}
	
	private static List<Command> makeCommands2(List<Location> locations, List<Truck> trucks,
												int bikeCnt, int loopCnt) {
		List<Command> ret = new ArrayList<>();
		for (Truck t : trucks) 
			ret.add(new Command(t.id, new ArrayList<>()));
		if(time%240 != 0) {
			int max_send_idx = 0, max_send = 0;
			int max_receive_idx = 0, max_receive = 0;
			for (int i = 0; i < befSend.length; i++) {
				if(max_send < befSend[i]) {
					max_send_idx = i;
					max_send = befSend[i];
				}
				if(max_receive < befReceive[i]) {
					max_receive_idx = i;
					max_receive = befReceive[i];
				}
			}
			Location sendLoc = null;
			Location loc = null;
			for (int i = 0; i < locations.size(); i++) {
				Location tmp = locations.get(i);
				if(tmp.id == max_receive_idx) sendLoc = tmp;
				if(tmp.id == max_send_idx) loc = tmp;
			}
			for (int i = 0; i < trucks.size(); i++) {
				Truck t = trucks.get(i);
				int moveSec = getDistance(sendLoc.x,sendLoc.y,t.x,t.y);
				int sendSec = getDistance(loc.x,loc.y,sendLoc.x,sendLoc.y);
				Command comm = ret.get(t.id);
				int loadBikeCount = (60 - comm.commandList.size() - (sendSec + moveSec)*6)/12;
				int loadBikeNum = loadBikeCount;
				int totalSec = (moveSec + sendSec + loadBikeCount*2) * 6;
				if(loadBikeCount < 1) continue;
				while(moveSec-- > 0) {
					int dir = move(t.x,t.y,sendLoc.x,sendLoc.y);
					comm.commandList.add(dir);
					t.x += dx[dir];
					t.y += dy[dir];
				}
				while(loadBikeCount-- > 0) {
					comm.commandList.add(5);
					t.loaded_bikes_count++;
					if(t.loaded_bikes_count >= 20) break;
				}
				while(sendSec-- > 0) {
					int dir = move(t.x,t.y,loc.x,loc.y);
					comm.commandList.add(dir);
					t.x += dx[dir];
					t.y += dy[dir];
				}
				while(loadBikeNum-- > loadBikeCount) {
					comm.commandList.add(6);
					t.loaded_bikes_count--;
				}
				if(comm.commandList.size()*6 + totalSec <= 60) i--;
			}
		}
		return ret;
	}
	private static int move(int x1, int y1, int x2, int y2) {
		if(x1==x2 && y1==y2) return 0;
		if(x2-x1==0) {
			if(y2-y1 > 0) return 2;
			else return 4;
		}else {
			if(x2-x1 > 0) return 3;
			else return 1;
		}
	}

	private static int getDistance(int x, int y, int x2, int y2) {
		return Math.abs(x-x2) + Math.abs(y-y2);
	}

	private static JSONArray commTojsonArray(List<Command> comm) {
		List<Map<String,Object>> comm_map = new ArrayList<>();
		try {
			for (Command com: comm) {
				Map<String, Object> map = new HashMap<>();
				map.put("truck_id",com.truck_id);
				map.put("command",com.commandList);
				comm_map.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new JSONArray(comm_map);
	}
	private static JSONObject score(String url, String token) {
		url += "/score";
		return callRestAPI(url, "GET", token, "");
	}
	private static JSONObject simulate(String url, String token,
										String commands) {
		url += "/simulate";
		return callRestAPI(url, "PUT", token,commands);
	}
	private static JSONObject locations(String url, String token) {
		url += "/locations";
		return callRestAPI(url, "GET", token,"");
	}
	private static JSONObject trucks(String url, String token) {
		url += "/trucks";
		return callRestAPI(url, "GET", token,"");
	}
	private static JSONObject start(String url,String token, String problem_id) {
		url += "/start";
		return callRestAPI(url, "POST",token, problem_id);
	}
	private static List<Truck> getTrucks(JSONObject jsonObj){
		List<Truck> truckList = new ArrayList<>();
		try {
			JSONArray trucks = jsonObj.getJSONArray("trucks");
			for (int i = 0; i < trucks.length(); i++) {
				JSONObject truck = trucks.getJSONObject(i);
				int id = truck.getInt("id");
				int location_id = truck.getInt("location_id");
				int x = N - location_id%5-1;
				int y = location_id/5;
				truckList.add(new Truck(id,
										truck.getInt("loaded_bikes_count"),
										location_id,x,y));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return truckList;
	}
	private static List<Location> getLocation(JSONObject jsonObj){
		List<Location> locList = new ArrayList<>();
		try {
			JSONArray locations = jsonObj.getJSONArray("locations");
			N = (int) Math.sqrt(locations.length());
			for (int i = 0; i < locations.length(); i++) {
				JSONObject loc = locations.getJSONObject(i);
				int id = loc.getInt("id");
				int count = loc.getInt("located_bikes_count");
				int x = N-id%5-1;
				int y = id/5;
				locList.add(new Location(id,count,x,y));
				if(bef[id] > count) befSend[id] = bef[id]-count;
				else befReceive[id] = count - bef[id];
				bef[id] = count;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return locList;
	}
	public static JSONObject callRestAPI(String api, 
										String method, 
										String token,
										String data) {
		JSONObject jsonObject = null;
		HttpURLConnection conn = null;
		try {
			URL url = new URL(api);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(method);
			if(method.equals("POST")) {
				conn.setRequestProperty("X-Auth-Token", token);
			}else if(method.equals("GET")){
				conn.setRequestProperty("Authorization", token);
			}else {
				conn.setRequestProperty("Authorization", token);
			}
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setDoOutput(true);
			if(!method.equals("GET")) {
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
				JSONObject sendData = new JSONObject();
				if(method.equals("POST")) {
					sendData.put("problem", data);
				}
				else {
					JSONArray JsonArr = new JSONArray(data);
					sendData.put("commands", JsonArr);
				}
				bw.write(sendData.toString());
				bw.flush();
				bw.close();
			}
			
			
			int respCode = conn.getResponseCode();
			if(respCode == 400) System.out.println("Bad Request");
			else if(respCode == 401) System.out.println("Invalid Token");
			else if(respCode == 403) System.out.println("Invalid user_key");
			else if(respCode == 500) System.out.println("Server error");
			else {
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				StringBuilder response = new StringBuilder();
				String line;
				while ((line = br.readLine()) != null)
					response.append(line);
				jsonObject = new JSONObject(response.toString());
				br.close();
			}
	    }catch(IOException e) {
	    	e.printStackTrace();
	    }catch (JSONException e) {
	    	System.out.println("not JSON format");
	    	e.printStackTrace();
		}
	      return jsonObject;
	   }

}