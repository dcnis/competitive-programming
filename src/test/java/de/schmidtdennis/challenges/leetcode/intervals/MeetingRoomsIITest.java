package de.schmidtdennis.challenges.leetcode.intervals;

import de.schmidtdennis.challenges.leetcode.utils.Utils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoSettings;


@MockitoSettings
class MeetingRoomsIITest {

    @InjectMocks
    private MeetingRoomsII testee;

    @Test
    public void testOne(){
        int result = testee.minMeetingRooms(Utils.read2DArray("[[1,5],[8,9],[8,9]]"));
        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    public void testTwo (){
        int result = testee.minMeetingRooms(Utils.read2DArray("[[2,11],[6,16],[11,16]]"));
        Assertions.assertThat(result).isEqualTo(2);
    }
}
