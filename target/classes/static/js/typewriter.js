/**
 * Created by harry on 12/31/16.
 */
var video = document.getElementById("bgvid");
var pauseButton = document.querySelector("#typewriter button");

function vidFade() {
    video.classList.add("stopfade");
}

video.addEventListener("ended", function() {
    video.pause();
    pauseButton.innerHTML = "Replay";
    // to capture IE10
    vidFade();
});

pauseButton.addEventListener("click", function() {
    video.classList.toggle("stopfade");
    if (video.paused) {
        video.play();
        pauseButton.innerHTML = "Pause";
    } else {
        video.pause();
        pauseButton.innerHTML = "Resume";
    }
})