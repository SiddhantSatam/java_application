package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.CrdRepository;
import ca.jrvs.apps.twitter.dto.Coordinates;
import ca.jrvs.apps.twitter.dto.Tweet;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Arrays;

import static ca.jrvs.apps.twitter.example.JsonParser.toJson;

public class TwitterServiceImp implements TwitterService {

    private static final int MAX_TWEET_LEN = 200;
    private CrdRepository dao;

    public TwitterServiceImp(CrdRepository dao) {
        this.dao = dao;
    }

    @Override
    public Tweet postTweet(String text, Double latitude, Double longitude) {
        Tweet postTweet = joinTweet(text, latitude, longitude);
        try{
            Tweet resp = (Tweet) dao.create(postTweet);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return postTweet;
    }

    public void showTweet(String id, String[] fields) {
        try {
            Tweet resp = (Tweet) dao.findbyId(id);
            System.out.println(toJson(resp));
        } catch (Exception e) {
            System.out.println("Can not show your tweet");
        }
    }

        public void deleteTweets(String[] id) {
            for (String i : id) {
                try {
                    Tweet resp = (Tweet) dao.deletebyId(i);
                    System.out.println(toJson(resp));
                } catch (Exception e) {
                    System.out.println("Can not delete all your tweet");
                }
            }

        }

        public Tweet joinTweet(String text, Double lat, Double longi) {

            if (text.length() > MAX_TWEET_LEN || lat > 90.0 || longi > 180.0 || lat < -90.0 || longi < -180.0) {
                throw new IllegalArgumentException("Arguments has some problem");
            }

            Tweet tweet = new Tweet();
            tweet.setText(text);
            Coordinates cordn = new Coordinates();
            cordn.setCoordinates(Arrays.asList(lat, longi));
            cordn.setType("Point");
            tweet.setCoordinates(cordn);


            try {
                System.out.println(toJson(tweet));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return tweet;
        }

        public boolean idValidation(String id) {
            return true;
        }
}
