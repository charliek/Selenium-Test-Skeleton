/**
 * This javascript should be injected into a page that has an autoplay
 * flowplayer. It will locate the first flowplayer on the page and
 * see if the palyer is playing.  Then the test harness should test
 * the IBSYS.testing.selenium.videoPlaying variable.
 */
IBSYS.using('IBSYS.testing.selenium');
IBSYS.testing.selenium.videoPlaying = false;
IBSYS.testing.selenium.videoTimeout = window.setInterval(function(){
    if(IBSYS.testing.selenium.videoPlaying){
        clearInterval(IBSYS.testing.selenium.videoTimeout);
    } else {
        var players = IBSYS.media.ibFlowplayer.getPlayers();
        var player = players[0].flowplayer;
        IBSYS.testing.selenium.videoPlaying = player.isPlaying() === true;
    }
}, 30);