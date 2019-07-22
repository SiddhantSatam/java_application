package ca.jrvs.apps.twitter.Service;

import ca.jrvs.apps.twitter.dao.CrdRepository;
import ca.jrvs.apps.twitter.dto.Tweet;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class TwitterServiceImpTest {

    @Test
    public void postTweet() {
        CrdRepository Mockdao = Mockito.mock(CrdRepo.class);
        TwitterService service = new TwitterServiceImp(Mockdao);
        Tweet mockTweet = new Tweet();
        mockTweet.setText("Mockito Tweet");
        when(Mockdao.create(any())).thenReturn(mockTweet);
        service.postTweet("Random Tweet", 0.0, 0.0);

        try {
            service.postTweet("Another Tweet", 50.0, 390.0);
            fail();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
