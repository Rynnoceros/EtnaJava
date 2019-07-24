import java.util;

public class Tweet {
    private String tweet_author_id;
    private String tweet_author_name;
}

public class Test {

    // On filtre les tweets sur les premiers tweet (retweeted == false) et
    //  sur les tweets contenant au moins un mot
    public List<Tweet> FilterTweet(List<Tweet> tweets)
    {
        List<Tweet> filteredTweet = null;

        if (tweets != null) {
            filteredTweet = tweets.stream()
                    .filter(tweet -> (tweet.getRetweeted() == false) &&
                            (Pattern.matches("\w*", tweet.getText())))
                    .map(tweet)
                    .collect(toList());
        }

        return filteredTweet;
    }
}
