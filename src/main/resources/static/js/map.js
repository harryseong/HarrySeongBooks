/**
 * Created by harry on 2/21/17.
 */
var flyButton = document.getElementById("fly");

mapboxgl.accessToken = 'pk.eyJ1IjoiaGFycnlzZW9uZyIsImEiOiJjaXQ4MW1uZzQwY3NhMm9wMWJmcDJkOTF0In0.0IESu9tlOZ2UCOO8Xqbl-g';
var map = new mapboxgl.Map({
    container: 'map',
    style: 'mapbox://styles/mapbox/dark-v9',
    center: [-74.50, 40],
    zoom: 9
});

flyButton.addEventListener('click', function () {
    // Fly to a random location by offsetting the point -74.50, 40
    // by up to 5 degrees.
    map.flyTo({
        center: [
            -74.50 + (Math.random() - 0.5) * 10,
            40 + (Math.random() - 0.5) * 10]
    });
});