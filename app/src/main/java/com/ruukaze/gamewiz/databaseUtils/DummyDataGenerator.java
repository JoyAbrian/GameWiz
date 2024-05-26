package com.ruukaze.gamewiz.databaseUtils;

import com.ruukaze.gamewiz.models.Library;
import com.ruukaze.gamewiz.models.User;

import java.util.ArrayList;

public class DummyDataGenerator {
    private static final ArrayList<User> dummyUsers = generateDummyUser();
    private static final ArrayList<Library> dummyLibrary = generateDummyLibrary();
    private static final ArrayList<Library> dummyWishlist = generateDummyWishlist();
    private static final ArrayList<Library> dummyPlaying = generateDummyPlaying();
    private static final ArrayList<Library> dummyPause = generateDummyPause();
    private static final ArrayList<Library> dummyCompleted = generateDummyCompleted();

    public static ArrayList<User> generateDummyUser() {
        ArrayList<User> users = new ArrayList<>();

        users.add(new User(1, "ruukaze", "05.10.2004", "Joy Abrian", "ruukaze562@gmail.com", "12345678"));
        users.add(new User(2, "mikasa422", "27.04.2024", "Mikasa422", "mikasa422@gmail.com", "12345678"));
        users.add(new User(3, "ShadowNinja", "21.03.2022", "John Doe", "shadow_ninja@gmail.com", "12345678"));
        users.add(new User(4, "DragonSlayer", "12.02.2023", "Jane Smith", "dragon_slayer@gmail.com", "12345678"));
        users.add(new User(5, "DarkKnight", "01.01.2021", "Alice Johnson", "dark_knight@gmail.com", "12345678"));
        users.add(new User(6, "EternalGamer", "11.06.2019", "Bob Brown", "eternal_gamer@gmail.com", "12345678"));
        users.add(new User(7, "MasterChief", "17.05.2017", "Emily Davis", "master_chief@gmail.com", "12345678"));
        users.add(new User(8, "SonicSpeed", "05.04.2013", "Michael Wilson", "sonic_speed@gmail.com", "12345678"));
        users.add(new User(9, "GamerGirl", "23.03.2011", "Jessica Lee", "gamer_girl@gmail.com", "12345678"));
        users.add(new User(10, "ProGamer", "14.02.2009", "David Clark", "pro_gamer@gmail.com", "12345678"));
        users.add(new User(11, "phoenixRising", "14.09.2000", "Samantha Johnson", "phoenix_rising@gmail.com", "12345678"));
        users.add(new User(12, "frostbite", "03.07.2001", "Alex Turner", "frost_bite@gmail.com", "12345678"));
        users.add(new User(13, "cyberWarrior", "22.05.1998", "Jessica Parker", "cyber_warrior@gmail.com", "12345678"));
        users.add(new User(14, "nightshade", "18.12.1995", "Christopher Lee", "nightshade@gmail.com", "12345678"));
        users.add(new User(15, "stormbreaker", "29.08.1992", "Amanda White", "storm_breaker@gmail.com", "12345678"));
        users.add(new User(16, "voidSeeker", "07.04.1990", "Matthew Clark", "void_seeker@gmail.com", "12345678"));
        users.add(new User(17, "lunarEclipse", "15.11.1988", "Jennifer Martinez", "lunar_eclipse@gmail.com", "12345678"));
        users.add(new User(18, "neonNinja", "26.06.1985", "David Adams", "neon_ninja@gmail.com", "12345678"));
        users.add(new User(19, "firestorm", "09.03.1983", "Sarah Miller", "firestorm83@gmail.com", "12345678"));
        users.add(new User(20, "icePhoenix", "12.07.1980", "Ryan Thompson", "ice_phoenix@gmail.com", "12345678"));
        users.add(new User(21, "shadowcaster", "25.09.1978", "Laura Garcia", "shadow_caster@gmail.com", "12345678"));
        users.add(new User(22, "thunderbolt", "08.02.1976", "Daniel Cooper", "thunder_bolt@gmail.com", "12345678"));
        users.add(new User(23, "spacewarrior", "16.05.1973", "Melissa King", "space_warrior@gmail.com", "12345678"));
        users.add(new User(24, "nightstalker", "30.08.1970", "Kevin Scott", "night_stalker@gmail.com", "12345678"));
        users.add(new User(25, "inferno", "04.12.1968", "Catherine Turner", "inferno68@gmail.com", "12345678"));
        users.add(new User(26, "frostwolf", "11.06.1965", "Steven Rodriguez", "frost_wolf@gmail.com", "12345678"));
        users.add(new User(27, "phantomblade", "23.09.1963", "Michelle Adams", "phantom_blade@gmail.com", "12345678"));
        users.add(new User(28, "emberfury", "07.03.1960", "Mark Wilson", "ember_fury@gmail.com", "12345678"));
        users.add(new User(29, "arcaneWizard", "12.07.1958", "Stephanie Hall", "arcane_wizard@gmail.com", "12345678"));
        users.add(new User(30, "soulreaper", "25.11.1955", "Timothy White", "soul_reaper@gmail.com", "12345678"));
        users.add(new User(31, "galacticGuardian", "08.04.1953", "Patricia Taylor", "galactic_guardian@gmail.com", "12345678"));
        users.add(new User(32, "novaStar", "16.08.1950", "Richard Martinez", "nova_star@gmail.com", "12345678"));
        users.add(new User(33, "shadowphoenix", "01.12.1948", "Karen Clark", "shadow_phoenix@gmail.com", "12345678"));
        users.add(new User(34, "frostfire", "11.06.1945", "Thomas Lewis", "frost_fire@gmail.com", "12345678"));
        users.add(new User(35, "stormrider", "23.09.1943", "Carol Adams", "storm_rider@gmail.com", "12345678"));
        users.add(new User(36, "crimsonreaper", "07.03.1940", "Robert Wilson", "crimson_reaper@gmail.com", "12345678"));
        users.add(new User(37, "shadowblade2", "12.07.1938", "Samantha Hall", "shadow_blade2@gmail.com", "12345678"));
        users.add(new User(38, "voidwalker2", "25.11.1935", "Christopher White", "void_walker2@gmail.com", "12345678"));
        users.add(new User(39, "twilightmage", "08.04.1933", "Emily Taylor", "twilight_mage@gmail.com", "12345678"));
        users.add(new User(40, "darkphoenix", "dark_phoenix2", "Michael Martinez", "dark_phoenix2@gmail.com", "12345678"));
        users.add(new User(41, "frostnova2", "01.12.1928", "Jessica Clark", "frost_nova2@gmail.com", "12345678"));
        users.add(new User(42, "nightfall2", "11.06.1925", "David Lewis", "night_fall2@gmail.com", "12345678"));
        users.add(new User(43, "thunderstrike2", "23.09.1923", "Jennifer Adams", "thunder_strike2@gmail.com", "12345678"));
        users.add(new User(44, "eternalflame2", "07.03.1920", "Steven Wilson", "eternal_flame2@gmail.com", "12345678"));
        users.add(new User(45, "voidreaper2", "12.07.1918", "Amanda Hall", "void_reaper2@gmail.com", "12345678"));
        users.add(new User(46, "nightwing2", "25.11.1915", "Matthew White", "night_wing2@gmail.com", "12345678"));
        users.add(new User(47, "dragonfire2", "08.04.1913", "Sarah Taylor", "dragon_fire2@gmail.com", "12345678"));
        users.add(new User(48, "shadowstorm2", "16.08.1910", "Emily Martinez", "shadow_storm2@gmail.com", "12345678"));
        users.add(new User(49, "frostbite2", "01.12.1908", "Daniel Clark", "frost_bite2@gmail.com", "12345678"));
        users.add(new User(50, "twilightshroud2", "11.06.1905", "Jessica Lewis", "twilight_shroud2@gmail.com", "12345678"));
        users.add(new User(51, "phantomflame2", "23.09.1903", "Andrew Adams", "phantom_flame2@gmail.com", "12345678"));
        users.add(new User(52, "embershade2", "07.03.1900", "Melissa Wilson", "ember_shade2@gmail.com", "12345678"));
        users.add(new User(53, "darkshroud2", "12.07.1898", "James Hall", "dark_shroud2@gmail.com", "12345678"));
        users.add(new User(54, "shadowfiend2", "25.11.1895", "Laura White", "shadow_fiend2@gmail.com", "12345678"));
        users.add(new User(55, "voidwalker3", "08.04.1893", "John Taylor", "void_walker3@gmail.com", "12345678"));
        users.add(new User(56, "frostnova3", "16.08.1890", "Rebecca Martinez", "frost_nova3@gmail.com", "12345678"));
        users.add(new User(57, "bloodraven2", "01.12.1888", "Michael Clark", "blood_raven2@gmail.com", "12345678"));
        users.add(new User(58, "nightstalker3", "11.06.1885", "Emily Lewis", "night_stalker3@gmail.com", "12345678"));
        users.add(new User(59, "stormchaser2", "23.09.1883", "Christopher Adams", "storm_chaser2@gmail.com", "12345678"));
        users.add(new User(60, "shadowblade3", "07.03.1880", "Sarah Wilson", "shadow_blade3@gmail.com", "12345678"));
        users.add(new User(61, "emberflare2", "12.07.1878", "Jessica Hall", "ember_flare2@gmail.com", "12345678"));
        users.add(new User(62, "twilightwhisper2", "25.11.1875", "Daniel White", "twilight_whisper2@gmail.com", "12345678"));
        users.add(new User(63, "thunderclap2", "08.04.1873", "Emma Taylor", "thunder_clap2@gmail.com", "12345678"));
        users.add(new User(64, "shadowdancer2", "16.08.1870", "Jacob Martinez", "shadow_dancer2@gmail.com", "12345678"));
        users.add(new User(65, "frostfang2", "01.12.1868", "Madison Clark", "frost_fang2@gmail.com", "12345678"));
        users.add(new User(66, "darkmoon2", "11.06.1865", "William Lewis", "dark_moon2@gmail.com", "12345678"));
        users.add(new User(67, "emberheart2", "23.09.1863", "Sophia Adams", "ember_heart2@gmail.com", "12345678"));
        users.add(new User(68, "shadowstep2", "07.03.1860", "Noah Wilson", "shadow_step2@gmail.com", "12345678"));
        users.add(new User(69, "frostfire3", "12.07.1858", "Olivia Hall", "frost_fire3@gmail.com", "12345678"));
        users.add(new User(70, "nightshade2", "25.11.1855", "Ethan White", "night_shade2@gmail.com", "12345678"));
        users.add(new User(71, "voidwalker4", "08.04.1853", "Sophie Taylor", "void_walker4@gmail.com", "12345678"));
        users.add(new User(72, "stormrage2", "16.08.1850", "Alexander Martinez", "storm_rage2@gmail.com", "12345678"));
        users.add(new User(73, "shadowflame2", "01.12.1848", "Ava Clark", "shadow_flame2@gmail.com", "12345678"));
        users.add(new User(74, "emberstorm2", "11.06.1845", "Logan Lewis", "ember_storm2@gmail.com", "12345678"));
        users.add(new User(75, "nightwalker2", "23.09.1843", "Isabella Adams", "night_walker2@gmail.com", "12345678"));
        users.add(new User(76, "shadowblade4", "07.03.1840", "Elijah Wilson", "shadow_blade4@gmail.com", "12345678"));
        users.add(new User(77, "frostbitten2", "12.07.1838", "Avery Hall", "frost_bitten2@gmail.com", "12345678"));
        users.add(new User(78, "shadowcaster2", "25.11.1835", "Mia White", "shadow_caster2@gmail.com", "12345678"));
        users.add(new User(79, "emberfury2", "08.04.1833", "Benjamin Taylor", "ember_fury2gmail.com", "12345678"));
        users.add(new User(80, "nightstalker4", "16.08.1830", "Chloe Martinez", "night_stalker4@gmail.com", "12345678"));
        users.add(new User(81, "shadowclaw2", "01.12.1828", "Christopher White", "shadow_claw2@gmail.com", "12345678"));
        users.add(new User(82, "frostblade2", "11.06.1825", "Hannah Lewis", "frost_blade2@gmail.com", "12345678"));
        users.add(new User(83, "thunderbolt3", "23.09.1823", "Zoe Adams", "thunder_bolt3@gmail.com", "12345678"));
        users.add(new User(84, "shadowhunter2", "07.03.1820", "Gabriel Wilson", "shadow_hunter2@gmail.com", "12345678"));
        users.add(new User(85, "frostwind2", "12.07.1818", "Natalie Hall", "frost_wind2@gmail.com", "12345678"));
        users.add(new User(86, "darkshadow2", "25.11.1815", "Lucas White", "dark_shadow2@gmail.com", "12345678"));
        users.add(new User(87, "embersoul2", "08.04.1813", "Hailey Taylor", "ember_soul2@gmail.com", "12345678"));
        users.add(new User(88, "shadowfury3", "16.08.1810", "Evan Martinez", "shadow_fury3@gmail.com", "12345678"));
        users.add(new User(89, "frostflame2", "01.12.1808", "Lily Clark", "frost_flame2@gmail.com", "12345678"));
        users.add(new User(90, "nightwing3", "11.06.1805", "Gavin Lewis", "night_wing3@gmail.com", "12345678"));
        users.add(new User(91, "shadowstorm3", "23.09.1803", "Madeline Adams", "shadow_storm3@gmail.com", "12345678"));
        users.add(new User(92, "emberblade2", "07.03.1800", "Connor Wilson", "ember_blade2@gmail.com", "12345678"));
        users.add(new User(93, "frostbite3", "12.07.1798", "Sophia Hall", "frost_bite3@gmail.com", "12345678"));
        users.add(new User(94, "darkflame2", "25.11.1795", "Blake White", "dark_flame2@gmail.com", "12345678"));
        users.add(new User(95, "shadowfire4", "08.04.1793", "Elena Taylor", "shadow_fire4@gmail.com", "12345678"));
        users.add(new User(96, "embershadow3", "16.08.1790", "Mason Martinez", "ember_shadow3@gmail.com", "12345678"));
        users.add(new User(97, "frostheart2", "01.12.1788", "Kylie Clark", "frost_heart2@gmail.com", "12345678"));
        users.add(new User(98, "nightfall3", "11.06.1785", "Jackson Lewis", "night_fall4@gmail.com", "12345678"));
        users.add(new User(99, "shadowflame3", "23.09.1783", "Olivia Adams", "shadow_flame5@gmail.com", "12345678"));
        users.add(new User(100, "embersong2", "07.03.1780", "Eli Wilson", "ember_song3@gmail.com", "12345678"));
        users.add(new User(101, "frostshade2", "12.07.1778", "Isaac Hall", "frost_shade2@gmail.com", "12345678"));
        users.add(new User(102, "shadowthief2", "25.11.1775", "Aria White", "shadow_thief2@gmail.com", "12345678"));
        users.add(new User(103, "thunderblade2", "08.04.1773", "Ella Taylor", "thunder_blade3@gmail.com", "12345678"));
        users.add(new User(104, "shadowstorm4", "16.08.1770", "Tyler Martinez", "shadow_storm4@gmail.com", "12345678"));
        users.add(new User(105, "frostflame3", "01.12.1768", "Aiden Clark", "frost_flame3@gmail.com", "12345678"));
        users.add(new User(106, "darkfire2", "11.06.1765", "Sophie Lewis", "dark_fire3@gmail.com", "12345678"));
        users.add(new User(107, "embershadow4", "23.09.1763", "Ethan Adams", "ember_shadow4@gmail.com", "12345678"));
        users.add(new User(108, "frostfang3", "12.07.1760", "Noah Hall", "frost_fang3@gmail.com", "12345678"));
        users.add(new User(109, "darkblade2", "25.11.1755", "Emma White", "dark_blade3@gmail.com", "12345678"));
        users.add(new User(110, "emberflame3", "08.04.1753", "Jackson Taylor", "ember_flame3@gmail.com", "12345678"));
        users.add(new User(111, "shadowheart2", "16.08.1750", "Mia Martinez", "shadow_heart2@gmail.com", "12345678"));
        users.add(new User(112, "frostfire4", "01.12.1748", "Logan Clark", "frost_fire4@gmail.com", "12345678"));
        users.add(new User(113, "darkness2", "11.06.1745", "Ava Lewis", "darkness2@gmail.com", "12345678"));
        users.add(new User(114, "embersong3", "23.09.1743", "Eli Adams", "ember_song4@gmail.com", "12345678"));
        users.add(new User(115, "shadowstrike2", "07.03.1740", "Aria Wilson", "shadow_strike2@gmail.com", "12345678"));
        users.add(new User(116, "frostgale2", "12.07.1738", "Oliver Hall", "frost_gale2@gmail.com", "12345678"));
        users.add(new User(117, "nightshade3", "25.11.1735", "Sophia White", "night_shade4@gmail.com", "12345678"));
        users.add(new User(118, "shadowflame4", "08.04.1733", "Lucas Taylor", "shadow_flame6@gmail.com", "12345678"));
        users.add(new User(119, "emberstorm3", "16.08.1730", "Avery Martinez", "ember_storm3@gmail.com", "12345678"));
        users.add(new User(120, "frostbite4", "01.12.1728", "Isabella Clark", "frost_bite4@gmail.com", "12345678"));
        users.add(new User(121, "shadowthorn2", "11.06.1725", "Ethan Lewis", "shadow_thorn2@gmail.com", "12345678"));

        return users;
    }

    public static ArrayList<Library> generateDummyLibrary() {
        ArrayList<Library> libraries = new ArrayList<>();

        libraries.add(new Library(1, 1, 11426, "library"));
        libraries.add(new Library(2, 1, 55057, "library"));

        return libraries;
    }

    public static ArrayList<Library> generateDummyWishlist() {
        ArrayList<Library> wishlists = new ArrayList<>();

        wishlists.add(new Library(1, 1, 143114, "wishlist"));
        wishlists.add(new Library(2, 1, 75235, "wishlist"));
        wishlists.add(new Library(3, 1, 151665, "wishlist"));
        wishlists.add(new Library(4, 1, 217590, "wishlist"));

        return wishlists;
    }

    public static ArrayList<Library> generateDummyPlaying() {
        ArrayList<Library> playings = new ArrayList<>();

        playings.add(new Library(1, 1, 20228, "playing"));
        playings.add(new Library(2, 1, 1942, "playing"));
        playings.add(new Library(3, 1, 1020, "playing"));
        playings.add(new Library(4, 1, 11397, "playing"));

        return playings;
    }

    public static ArrayList<Library> generateDummyPause() {
        ArrayList<Library> pauses = new ArrayList<>();

        pauses.add(new Library(5, 1, 5606, "pause"));
        pauses.add(new Library(6, 1, 1369, "pause"));
        pauses.add(new Library(7, 1, 536, "pause"));
        pauses.add(new Library(8, 1, 1833, "pause"));

        return pauses;
    }

    public static ArrayList<Library> generateDummyCompleted() {
        ArrayList<Library> completes = new ArrayList<>();

        completes.add(new Library(9, 1, 37034, "completed"));
        completes.add(new Library(10, 1, 16992, "completed"));
        completes.add(new Library(11, 1, 16992, "completed"));
        completes.add(new Library(12, 1, 3025, "completed"));
        completes.add(new Library(13, 1, 27421, "completed"));

        return completes;
    }
}