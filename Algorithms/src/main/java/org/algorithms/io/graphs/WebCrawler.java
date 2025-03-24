package org.algorithms.io.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.regex.Pattern;

public class WebCrawler {
    public static void main(String[] args) {
        var webCrawler = new WebCrawler();
        webCrawler.discoverWeb("https://www.bbc.com");
    }
    private static final String URL_REGEX = "https://(\\w+\\.)*(\\w+)";
    private final Pattern pattern;
    private final Queue<String> bfs;
    private final Set<String> visited;
    public WebCrawler() {
        this.bfs = new LinkedList<>();
        this.pattern = Pattern.compile(URL_REGEX);
        this.visited = new HashSet<>();
    }

    public void discoverWeb(String url) {
        this.bfs.add(url);
        visited.add(url);
        while(!bfs.isEmpty()) {
            var link = bfs.poll();
            var html = readUrl(link);
            var matcher = pattern.matcher(html);
            while(matcher.find()) {
                var w = matcher.group();
                if(!visited.contains(w)) {
                    System.out.println("Website found: "+ w);
                    visited.add(w);
                    bfs.add(w);
                }
            }
        }
    }

    private String readUrl(String url) {
        var builder = new StringBuilder();
        BufferedReader reader = null;
        try {
            var u = new URL(url);
            reader = new BufferedReader(new InputStreamReader(u.openStream()));
            var line = "";
            while((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch(Exception e) {
            System.out.println("URL cannot be retrieved");
        } finally {
            try {
                if(reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return builder.toString();
    }
}
