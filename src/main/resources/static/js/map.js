/**
 * Created by harry on 2/21/17.
 */

mapboxgl.accessToken = 'pk.eyJ1IjoiaGFycnlzZW9uZyIsImEiOiJjaXQ4MW1uZzQwY3NhMm9wMWJmcDJkOTF0In0.0IESu9tlOZ2UCOO8Xqbl-g';

var seoul = new mapboxgl.LngLat(127.02, 37.53);
var collegeStation = new mapboxgl.LngLat(-96.34, 30.62);
var westLafayette = new mapboxgl.LngLat(-86.91, 40.43);
var edenPrairie = new mapboxgl.LngLat(-93.48, 44.85);
var evanston = new mapboxgl.LngLat(-87.69, 42.05);
var chicago = new mapboxgl.LngLat(-87.63, 41.89);

var map = new mapboxgl.Map({
    container: 'map',
    style: 'mapbox://styles/mapbox/dark-v9',
    center: seoul,
    zoom: 10
});

var fly = document.getElementById("flyButtonText");

flyButton.addEventListener('click', function () {
    if (fly.innerHTML == "FLY TO 1ST-6TH GRADE"){
        map.flyTo({center: collegeStation, zoom: 10});
        fly.innerHTML = "FLY TO 6TH-8TH GRADE";
        cityName.innerHTML = "College Station, TX";
        cityYears.innerHTML = "[1997-2002]";
        cityDescription.innerHTML = "This town was my first exposure to the United States. " +
            "Here, I attended Rock Prairie Elementary School and learned English.";
    }
    else if (fly.innerHTML == "FLY TO 6TH-8TH GRADE"){
        map.flyTo({center: westLafayette, zoom: 10});
        fly.innerHTML = "FLY TO 8TH-12TH GRADE";
        cityName.innerHTML = "West Lafayette, IN";
        cityYears.innerHTML = "[2002-2004]";
        cityDescription.innerHTML = "This was where I went to middle school at West Lafayette " +
            "Junior/Senior High School.";
    }
    else if (fly.innerHTML == "FLY TO 8TH-12TH GRADE"){
        map.flyTo({center: edenPrairie, zoom: 10});
        fly.innerHTML = "FLY TO COLLEGE/WORK";
        cityName.innerHTML = "Eden Prairie, MN";
        cityYears.innerHTML = "[2004-2009]";
        cityDescription.innerHTML = "This is where I attended high school at Eden Prairie High School. " +
            "Though I moved around a couple times, I tell people that I am from Minnesota because I spent " +
            "my high school days here. My parents have since moved to Monticello, Minnesota to start their " +
            "mushroom farm business.";
    }
    else if (fly.innerHTML == "FLY TO COLLEGE/WORK"){
        map.flyTo({center: evanston, zoom: 10});
        fly.innerHTML = "FLY TO HOMETOWN";
        cityName.innerHTML = "Evanston, IL";
        cityYears.innerHTML = "[2009-present]";
        cityDescription.innerHTML = "This is where I attended Northwestern University. Upon graduation " +
            "with a Bachelors, I started work at Student Affairs IT at Northwestern University.";
    }
    else if (fly.innerHTML == "FLY TO HOMETOWN"){
        map.flyTo({center: seoul, zoom: 10});
        fly.innerHTML = "FLY TO 1ST-6TH GRADE";
        cityName.innerHTML = "Seoul, South Korea";
        cityYears.innerHTML = "[1997-2002]";
        cityDescription.innerHTML = "This was where I was born.";
    }

    // Fly to a random location by offsetting the Chicago point
    // by up to 5 degrees.
    /*
    map.flyTo({
        center: [-87.63 + (Math.random() - 0.5) * 10,
                  41.89 + (Math.random() - 0.5) * 10]
    });
    */
});