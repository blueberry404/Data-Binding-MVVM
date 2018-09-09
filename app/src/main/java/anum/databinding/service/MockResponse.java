package anum.databinding.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import anum.databinding.models.PlaceModel;
import anum.databinding.models.User;

public class MockResponse {

    public static User getUserData() {
        User user = new User("David", "Henry",
                "david.henry@gmail.com", 3);
        return user;
    }

    public static List<PlaceModel> getPlaces() {
        List<PlaceModel> models = new ArrayList<>();
        PlaceModel place1 = new PlaceModel("Chitta Katha Lake",
                "http://www.theweekender.com.pk/wp-content/uploads/2018/04/Chitta-Katha-Lake.jpg",
                "Chitta Katha Lake is a lake located in Shounter valley, Azad Kashmir at the elevation of 13,500 feet (4,100 m).[1] The word Chitta means white and Katha means water reservoir, So a reservoir of clear water is about lake. The major attraction of the lake is due to its milky white colors of water from which the name of the lake is derived");
        PlaceModel place2 = new PlaceModel("Neelum Valley",
                "http://1.bp.blogspot.com/_bixrHDERXxo/TRH8NYn79HI/AAAAAAAAAYY/qHDy5E7NjtI/s1600/Upper+Neelum.jpg",
                "The Neelam Valley is the northernmost region and district of Azad Kashmir in Pakistan. The district has a population of 191,251 according to the 2017 Census. The district was badly affected by the 2005 Kashmir earthquake");
        PlaceModel place3 = new PlaceModel("Murree",
                "http://1.bp.blogspot.com/_bixrHDERXxo/TRH8NYn79HI/AAAAAAAAAYY/qHDy5E7NjtI/s1600/Upper+Neelum.jpghttps://www.samaa.tv/wp-content/uploads/2018/02/APP52-12Murree.jpg",
                "Since the Independence of Pakistan in 1947, Murree has retained its position as a popular hill station, noted for its pleasant summers. A large number of tourists visit the town from the Islamabad-Rawalpindi area. The town also serves as a transit point for tourist's visiting Azad Kashmir and Abbottabad. The town is noted for its Tudorbethan and neo-gothic architecture. The Government of Pakistan owns a summer retreat in Murree, where foreign dignitaries including heads of state often visit.");

        PlaceModel place4 = new PlaceModel("Kund Malir Beach",
                "http://kundmalir.com/wp-content/uploads/2016/04/serv2.png",
                "Kund Malir' is a beach in Balochistan, Pakistan located in Hingol National Park, about 145 km from Zero-Point on Makran Coastal Highway. The drive between Kund Malir and Ormara is considered to be scenic. The area is part of Hingol National Park which is the largest in Pakistan. Traveling time from Karachi is around 4 hours and 03 hours from Gwadar. ");

        PlaceModel place5 = new PlaceModel("Gorakh Hills",
                "https://www.dailyevents.pk/wp-content/uploads/2018/01/facebook_event_178101239448139.jpg",
                "The Gorakh Hill station is situated 423 km from Karachi and nearly 8 hours driving distance. The Hill station attracts thousands of tourists from the city.");

        PlaceModel place6 = new PlaceModel("Hunza Valley",
                "https://travel.jumia.com/blog/pk/wp-content/uploads/2015/03/bortih-lake.jpg",
                "Hunza is a mountainous valley in the Gilgit-Baltistan region of Pakistan. The Hunza is situated in the extreme northern part of Pakistan, bordering with the Wakhan Corridor of Afghanistan and the Xinjiang region of China.");

        PlaceModel place7 = new PlaceModel("Passu Cones",
                "http://www.fehmeedakhan.com/wp-content/uploads/2016/08/Passu-Cathedral-660x330.jpg",
                "Passu is a small village located in the Gilgit Baltistan region of northern Pakistan. Situated along the Karakoram Highway in Upper Hunza, Passu is a popular tourist destination because of its easily accessible sweeping landscapes, and vistas of the 7,478 m (24,534 ft) tall Passu Sar mountain, the Passu Glacier, and Passu Cones. ");

        PlaceModel place8 = new PlaceModel("Khunjerab Pass",
                "https://htv.com.pk/wp-content/uploads/2015/08/pass.jpg",
                "Khunjerab Pass or (elevation 4,880 metres or 16,010 feet) is a high mountain pass in the Karakoram Mountains in a strategic position on the northern border of the Pakistani region of Gilgit–Baltistan Hunza – Nagar District on the southwest border of the Xinjiang region of China. Its name is derived from two words of the local Wakhi language : 'Khun' means Blood and 'Jerav' means a creek coming from spring water/water falling. ");

        PlaceModel[] places = {place1, place2, place3, place4, place5, place6, place7, place8};
        models.addAll(Arrays.asList(places));
        return models;
    }
}
