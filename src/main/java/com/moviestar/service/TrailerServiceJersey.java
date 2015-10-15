//package com.moviestar.service;
//
//import java.io.InputStream;
//import java.io.Reader;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.StatusLine;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.HttpClients;
//import org.json.XML;
//
//import com.mashape.unirest.http.HttpResponse;
//
//public class TrailerServiceJersey {
//
//	public static void main(String[] args) {
//		String url = "http://api.traileraddict.com/format=xml";
//		HttpClient httpclient = null;
//		HttpGet httpGet = null;
//		HttpResponse response = null;
//		StatusLine status = null;
//		HttpEntity entity = null;
//		InputStream data = null;
//		Reader reader = null;
//		XML xml = new XML();
//
//		// Envelope envelope = null;
//		// Playlist playlist = null;
//
//		try {
//			httpclient = HttpClients.createDefault();
//			httpGet = new HttpGet(url);
//
//			response = httpclient.execute(httpGet);
//			status = response.getStatusLine();
//
//			if (status.getStatusCode() == 200) {
//				entity = response.getEntity();
//				data = entity.getContent();
//
//				try {
//					// Attempt to parse the data as JSON
//					reader = new InputStreamReader(data);
//
//					envelope = json.fromJson(reader, Envelope.class);
//					playlist = envelope.getPlaylist();
//
//					// Print the info
//					printChannel(playlist.getChannel());
//					if (playlist.getSong() != null) {
//						printSong(playlist.getSong());
//					}
//					if (playlist.getNextSong() != null) {
//						printSong(playlist.getNextSong());
//					}
//				} catch (Exception e) {
//					// Something didn't went well. No calls for us.
//					e.printStackTrace();
//					System.out.println("SR didn't respond in a good manner.");
//				}
//			} else {
//				// Something didn't went well. No calls for us.
//				System.out.println("SR didn't respond in a good manner.");
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void printChannel(Channel channel) {
//		System.out.println("Channel name: " + channel.getName());
//		System.out.println("Channel id: " + channel.getId());
//	}
//
//	public static void printSong(Song song) {
//		System.out.println("Artist: " + song.getArtist());
//		System.out.println("Title: " + song.getTitle());
//		System.out.println("Description: " + song.getDescription());
//	}
//}
