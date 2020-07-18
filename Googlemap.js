$('#map').gmap3({
    map: {
        options: {
            center: [53.128381, 17.998191],
            zoom: 15,
            panControl: false,
            zoomControl: false
        }
    },
    marker: {
        values:[{
            latLng: [53.128381, 17.998191],
            data: 'Dworcowa 50'
        }],
        events:{
            click: function(marker, event, context) {
                var map = $(this).gmap3('get'),
                    infowindow = $(this).gmap3({get:{name:'infowindow'}});
                if (infowindow) {
                    infowindow.open(map, marker);
                    infowindow.setContent(context.data);
                } else {
                    $(this).gmap3({
                        infowindow: {
                            anchor: marker,
                            options: {content: context.data}
                        }
                    });
                }
            }
        }
    }
});