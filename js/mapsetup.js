
var mymap = L.map('map').setView([0,0], 2); // Latitude, Longitude, Zoom Level

L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
    maxZoom: 19,
    minZoom: 2,
    attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
}).addTo(mymap);

//L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
//    maxZoom: 19,
//    attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
//}).addTo(mymap);

L.Control.Watermark = L.Control.extend({
    onAdd: function(map) {
        var img = L.DomUtil.create('div');

        img.className = "map-controls-bar"
        img.innerHTML = "" +
            "<div id='currentmodel' class='map-controls-bar-modelsel-current'>" +
            "No Model Selected" +
            "</div>" +
            "<span id='statustext' class='map-controls-bar-status'>" +
            "<svg width=\"10\" height=\"10\" xmlns=\"http://www.w3.org/2000/svg\">\n" +
            "  <circle cy=\"5\" cx=\"5\" r=\"4\" fill=\"#d42020\">\n" +
            "</svg>Not Connected to API Server" +
            "</span>";

        return img;
    },

    onRemove: function(map) {
        // Nothing to do here
    }
});

L.control.watermark = function(opts) {
    return new L.Control.Watermark(opts);
}

L.control.watermark({ position: 'bottomleft' }).addTo(mymap);