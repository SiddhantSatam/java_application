package ca.jrvs.apps.twitter.Service;

import ca.jrvs.apps.twitter.dao.CrdRepository;
import ca.jrvs.apps.twitter.dto.Tweet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TwitterServiceImpTest1 {

    @Mock
    private CrdRepository mockDao;

    @InjectMocks
    private TwitterServiceImp service;

    @Test
    public void postTweet() {

        Tweet mockTweet = new Tweet();
        mockTweet.setText("Mockito Tweet");
        when(mockDao.create(any())).thenReturn(mockTweet);
        service.postTweet("Random Tweet", 0.0, 0.0);

        try {
            service.postTweet("Another Tweet", 50.0, 390.0);
            fail();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
