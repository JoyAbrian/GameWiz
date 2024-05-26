package com.ruukaze.gamewiz.databaseUtils;

import androidx.annotation.NonNull;

import com.ruukaze.gamewiz.R;
import com.ruukaze.gamewiz.models.Library;
import com.ruukaze.gamewiz.models.User;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DummyDataGenerator {
    public static final ArrayList<User> dummyUsers = generateDummyUser();
    public static final ArrayList<Library> dummyLibraries = generateDummyLibrary();


    public static ArrayList<User> generateDummyUser() {
        ArrayList<User> users = new ArrayList<>();

        users.add(new User(1, "ruukaze", "05.10.2004", R.drawable.avatar_16, 1, "Joy Abrian", "ruukaze562@gmail.com", "12345678"));
        users.add(new User(2, "mikasa422", "27.04.2024", R.drawable.avatar_5, 2, "Mikasa422", "mikasa422@gmail.com", "12345678"));
        users.add(new User(3, "ShadowNinja", "21.03.2022", R.drawable.avatar_18, 3, "John Doe", "shadow_ninja@gmail.com", "12345678"));
        users.add(new User(4, "DragonSlayer", "12.02.2023", R.drawable.avatar_24, 4, "Jane Smith", "dragon_slayer@gmail.com", "12345678"));
        users.add(new User(5, "DarkKnight", "01.01.2021", R.drawable.avatar_30, 5, "Alice Johnson", "dark_knight@gmail.com", "12345678"));
        users.add(new User(6, "EternalGamer", "11.06.2019", R.drawable.avatar_12, 6, "Bob Brown", "eternal_gamer@gmail.com", "12345678"));
        users.add(new User(7, "MasterChief", "17.05.2017", R.drawable.avatar_7, 7, "Emily Davis", "master_chief@gmail.com", "12345678"));
        users.add(new User(8, "SonicSpeed", "05.04.2013", R.drawable.avatar_35, 8, "Michael Wilson", "sonic_speed@gmail.com", "12345678"));
        users.add(new User(9, "GamerGirl", "23.03.2011", R.drawable.avatar_19, 9, "Jessica Lee", "gamer_girl@gmail.com", "12345678"));
        users.add(new User(10, "ProGamer", "14.02.2009", R.drawable.avatar_28, 10, "David Clark", "pro_gamer@gmail.com", "12345678"));
        users.add(new User(11, "phoenixRising", "14.09.2000", R.drawable.avatar_9, 1, "Samantha Johnson", "phoenix_rising@gmail.com", "12345678"));
        users.add(new User(12, "frostbite", "03.07.2001", R.drawable.avatar_21, 2, "Alex Turner", "frost_bite@gmail.com", "12345678"));
        users.add(new User(13, "cyberWarrior", "22.05.1998", R.drawable.avatar_16, 3, "Jessica Parker", "cyber_warrior@gmail.com", "12345678"));
        users.add(new User(14, "nightshade", "18.12.1995", R.drawable.avatar_6, 4, "Christopher Lee", "nightshade@gmail.com", "12345678"));
        users.add(new User(15, "stormbreaker", "29.08.1992", R.drawable.avatar_25, 5, "Amanda White", "storm_breaker@gmail.com", "12345678"));
        users.add(new User(16, "voidSeeker", "07.04.1990", R.drawable.avatar_13, 6, "Matthew Clark", "void_seeker@gmail.com", "12345678"));
        users.add(new User(17, "lunarEclipse", "15.11.1988", R.drawable.avatar_4, 7, "Jennifer Martinez", "lunar_eclipse@gmail.com", "12345678"));
        users.add(new User(18, "neonNinja", "26.06.1985", R.drawable.avatar_36, 8, "David Adams", "neon_ninja@gmail.com", "12345678"));
        users.add(new User(19, "firestorm", "09.03.1983", R.drawable.avatar_2, 9, "Sarah Miller", "firestorm83@gmail.com", "12345678"));
        users.add(new User(20, "icePhoenix", "12.07.1980", R.drawable.avatar_17, 10, "Ryan Thompson", "ice_phoenix@gmail.com", "12345678"));
        users.add(new User(21, "shadowcaster", "25.09.1978", R.drawable.avatar_27, 1, "Laura Garcia", "shadow_caster@gmail.com", "12345678"));
        users.add(new User(22, "thunderbolt", "08.02.1976", R.drawable.avatar_8, 2, "Daniel Cooper", "thunder_bolt@gmail.com", "12345678"));
        users.add(new User(23, "spacewarrior", "16.05.1973", R.drawable.avatar_31, 3, "Melissa King", "space_warrior@gmail.com", "12345678"));
        users.add(new User(24, "nightstalker", "30.08.1970", R.drawable.avatar_20, 4, "Kevin Scott", "night_stalker@gmail.com", "12345678"));
        users.add(new User(25, "inferno", "04.12.1968", R.drawable.avatar_29, 5, "Catherine Turner", "inferno68@gmail.com", "12345678"));
        users.add(new User(26, "frostwolf", "11.06.1965", R.drawable.avatar_23, 6, "Steven Rodriguez", "frost_wolf@gmail.com", "12345678"));
        users.add(new User(27, "phantomblade", "23.09.1963", R.drawable.avatar_32, 7, "Michelle Adams", "phantom_blade@gmail.com", "12345678"));
        users.add(new User(28, "emberfury", "07.03.1960", R.drawable.avatar_14, 8, "Mark Wilson", "ember_fury@gmail.com", "12345678"));
        users.add(new User(29, "arcaneWizard", "12.07.1958", R.drawable.avatar_1, 9, "Stephanie Hall", "arcane_wizard@gmail.com", "12345678"));
        users.add(new User(30, "soulreaper", "25.11.1955", R.drawable.avatar_33, 10, "Timothy White", "soul_reaper@gmail.com", "12345678"));
        users.add(new User(31, "galacticGuardian", "08.04.1953", R.drawable.avatar_34, 1, "Patricia Taylor", "galactic_guardian@gmail.com", "12345678"));
        users.add(new User(32, "novaStar", "16.08.1950", R.drawable.avatar_22, 2, "Richard Martinez", "nova_star@gmail.com", "12345678"));
        users.add(new User(33, "shadowphoenix", "01.12.1948", R.drawable.avatar_10, 3, "Karen Clark", "shadow_phoenix@gmail.com", "12345678"));
        users.add(new User(34, "frostfire", "11.06.1945", R.drawable.avatar_26, 4, "Thomas Lewis", "frost_fire@gmail.com", "12345678"));
        users.add(new User(35, "stormrider", "23.09.1943", R.drawable.avatar_15, 5, "Carol Adams", "storm_rider@gmail.com", "12345678"));
        users.add(new User(36, "crimsonreaper", "07.03.1940", R.drawable.avatar_3, 6, "Robert Wilson", "crimson_reaper@gmail.com", "12345678"));
        users.add(new User(37, "shadowblade2", "12.07.1938", R.drawable.avatar_11, 7, "Samantha Hall", "shadow_blade2@gmail.com", "12345678"));
        users.add(new User(38, "voidwalker2", "25.11.1935", R.drawable.avatar_37, 8, "Christopher White", "void_walker2@gmail.com", "12345678"));
        users.add(new User(39, "twilightmage", "08.04.1933", R.drawable.avatar_5, 9, "Emily Taylor", "twilight_mage@gmail.com", "12345678"));
        users.add(new User(40, "darkphoenix", "dark_phoenix2", R.drawable.avatar_38, 10, "Michael Martinez", "dark_phoenix2@gmail.com", "12345678"));
        users.add(new User(41, "frostnova2", "01.12.1928", R.drawable.avatar_39, 1, "Jessica Clark", "frost_nova2@gmail.com", "12345678"));
        users.add(new User(42, "nightfall2", "11.06.1925", R.drawable.avatar_24, 2, "David Lewis", "night_fall2@gmail.com", "12345678"));
        users.add(new User(43, "thunderstrike2", "23.09.1923", R.drawable.avatar_17, 3, "Jennifer Adams", "thunder_strike2@gmail.com", "12345678"));
        users.add(new User(44, "eternalflame2", "07.03.1920", R.drawable.avatar_21, 4, "Steven Wilson", "eternal_flame2@gmail.com", "12345678"));
        users.add(new User(45, "voidreaper2", "12.07.1918", R.drawable.avatar_25, 5, "Melissa Taylor", "void_reaper2@gmail.com", "12345678"));
        users.add(new User(46, "shadowhunter2", "25.11.1915", R.drawable.avatar_2, 6, "Daniel Scott", "shadow_hunter2@gmail.com", "12345678"));
        users.add(new User(47, "stormbringer2", "08.04.1913", R.drawable.avatar_9, 7, "Laura Turner", "storm_bringer2@gmail.com", "12345678"));
        users.add(new User(48, "frostbite4", "11.06.1910", R.drawable.avatar_30, 8, "Robert Hall", "frost_bite4@gmail.com", "12345678"));
        users.add(new User(49, "shadowthorn2", "11.06.1725", R.drawable.avatar_14, 9, "Ethan Lewis", "shadow_thorn2@gmail.com", "12345678"));
        users.add(new User(50, "icequeen", "21.10.2001", R.drawable.avatar_38, 10, "Isabella Green", "icequeen2001@gmail.com", "12345678"));
        users.add(new User(51, "darkwizard", "14.09.2000", R.drawable.avatar_1, 1, "Liam Hughes", "darkwizard00@gmail.com", "12345678"));
        users.add(new User(52, "sunwarrior", "03.07.1999", R.drawable.avatar_2, 2, "Sophia Brooks", "sunwarrior99@gmail.com", "12345678"));
        users.add(new User(53, "lightbringer", "22.05.1998", R.drawable.avatar_3, 3, "Mason Foster", "lightbringer98@gmail.com", "12345678"));
        users.add(new User(54, "stormhunter", "18.12.1997", R.drawable.avatar_4, 4, "Mia Gray", "stormhunter97@gmail.com", "12345678"));
        users.add(new User(55, "crimsonmage", "29.08.1996", R.drawable.avatar_5, 5, "Noah Perry", "crimsonmage96@gmail.com", "12345678"));
        users.add(new User(56, "nightfury", "07.04.1995", R.drawable.avatar_6, 6, "Ava Bryant", "nightfury95@gmail.com", "12345678"));
        users.add(new User(57, "frostqueen", "15.11.1994", R.drawable.avatar_7, 7, "Ethan Ward", "frostqueen94@gmail.com", "12345678"));
        users.add(new User(58, "thunderking", "26.06.1993", R.drawable.avatar_8, 8, "Olivia Phillips", "thunderking93@gmail.com", "12345678"));
        users.add(new User(59, "shadowreaper", "09.03.1992", R.drawable.avatar_9, 9, "Lucas Mitchell", "shadowreaper92@gmail.com", "12345678"));
        users.add(new User(60, "phoenixfire", "12.07.1991", R.drawable.avatar_10, 10, "Amelia Campbell", "phoenixfire91@gmail.com", "12345678"));
        users.add(new User(61, "shadowhunter", "25.09.1990", R.drawable.avatar_11, 1, "Alexander Carter", "shadowhunter90@gmail.com", "12345678"));
        users.add(new User(62, "darkknight", "08.02.1989", R.drawable.avatar_12, 2, "Emily Roberts", "darkknight89@gmail.com", "12345678"));
        users.add(new User(63, "lunarshadow", "16.05.1988", R.drawable.avatar_13, 3, "Benjamin Evans", "lunarshadow88@gmail.com", "12345678"));
        users.add(new User(64, "stormbringer", "30.08.1987", R.drawable.avatar_14, 4, "Charlotte Turner", "stormbringer87@gmail.com", "12345678"));
        users.add(new User(65, "arcaneangel", "04.12.1986", R.drawable.avatar_15, 5, "James Stewart", "arcaneangel86@gmail.com", "12345678"));
        users.add(new User(66, "frostmage", "11.06.1985", R.drawable.avatar_16, 6, "Abigail Hughes", "frostmage85@gmail.com", "12345678"));
        users.add(new User(67, "shadowwarrior", "23.09.1984", R.drawable.avatar_17, 7, "Jack Patterson", "shadowwarrior84@gmail.com", "12345678"));
        users.add(new User(68, "nightfall", "07.03.1983", R.drawable.avatar_18, 8, "Sophie Henderson", "nightfall83@gmail.com", "12345678"));
        users.add(new User(69, "crimsonfire", "12.07.1982", R.drawable.avatar_19, 9, "Daniel Collins", "crimsonfire82@gmail.com", "12345678"));
        users.add(new User(70, "frostphoenix", "25.11.1981", R.drawable.avatar_20, 10, "Grace Price", "frostphoenix81@gmail.com", "12345678"));
        users.add(new User(71, "darkshadow", "08.04.1980", R.drawable.avatar_21, 1, "Henry Reed", "darkshadow80@gmail.com", "12345678"));
        users.add(new User(72, "stormrage", "16.08.1979", R.drawable.avatar_22, 2, "Madison Howard", "stormrage79@gmail.com", "12345678"));
        users.add(new User(73, "shadowknight", "01.12.1978", R.drawable.avatar_23, 3, "Oliver Russell", "shadowknight78@gmail.com", "12345678"));
        users.add(new User(74, "frostwarrior", "11.06.1977", R.drawable.avatar_24, 4, "Chloe Baker", "frostwarrior77@gmail.com", "12345678"));
        users.add(new User(75, "phoenixrider", "23.09.1976", R.drawable.avatar_25, 5, "Michael Bennett", "phoenixrider76@gmail.com", "12345678"));
        users.add(new User(76, "shadowdancer", "07.03.1975", R.drawable.avatar_26, 6, "Emma Peterson", "shadowdancer75@gmail.com", "12345678"));
        users.add(new User(77, "darkwarrior", "12.07.1974", R.drawable.avatar_27, 7, "William Murphy", "darkwarrior74@gmail.com", "12345678"));
        users.add(new User(78, "frostreaper", "25.11.1973", R.drawable.avatar_28, 8, "Ava Bell", "frostreaper73@gmail.com", "12345678"));
        users.add(new User(79, "shadowflame", "08.04.1972", R.drawable.avatar_29, 9, "Liam Morgan", "shadowflame72@gmail.com", "12345678"));
        users.add(new User(80, "darkrider", "16.08.1971", R.drawable.avatar_30, 10, "Isabella Bailey", "darkrider71@gmail.com", "12345678"));
        users.add(new User(81, "stormhunter2", "01.12.1970", R.drawable.avatar_31, 1, "James Cooper", "stormhunter2@gmail.com", "12345678"));
        users.add(new User(82, "frostmage2", "11.06.1969", R.drawable.avatar_32, 2, "Emily Green", "frostmage2@gmail.com", "12345678"));
        users.add(new User(83, "shadowwarrior2", "23.09.1968", R.drawable.avatar_33, 3, "Alexander Ward", "shadowwarrior2@gmail.com", "12345678"));
        users.add(new User(84, "nightfall2", "07.03.1967", R.drawable.avatar_34, 4, "Olivia Phillips", "nightfall2@gmail.com", "12345678"));
        users.add(new User(85, "crimsonfire2", "12.07.1966", R.drawable.avatar_35, 5, "Mason Mitchell", "crimsonfire2@gmail.com", "12345678"));
        users.add(new User(86, "frostphoenix2", "25.11.1965", R.drawable.avatar_36, 6, "Charlotte Campbell", "frostphoenix2@gmail.com", "12345678"));
        users.add(new User(87, "darkshadow2", "08.04.1964", R.drawable.avatar_37, 7, "Lucas Carter", "darkshadow2@gmail.com", "12345678"));
        users.add(new User(88, "stormrage2", "16.08.1963", R.drawable.avatar_38, 8, "Amelia Roberts", "stormrage2@gmail.com", "12345678"));
        users.add(new User(89, "shadowknight2", "01.12.1962", R.drawable.avatar_39, 9, "Benjamin Evans", "shadowknight2@gmail.com", "12345678"));
        users.add(new User(90, "frostwarrior2", "11.06.1961", R.drawable.avatar_40, 10, "Sophie Henderson", "frostwarrior2@gmail.com", "12345678"));
        users.add(new User(91, "phoenixrider2", "23.09.1960", R.drawable.avatar_1, 1, "Daniel Collins", "phoenixrider2@gmail.com", "12345678"));
        users.add(new User(92, "shadowdancer2", "07.03.1959", R.drawable.avatar_2, 2, "Grace Price", "shadowdancer2@gmail.com", "12345678"));
        users.add(new User(93, "darkwarrior2", "12.07.1958", R.drawable.avatar_3, 3, "Henry Reed", "darkwarrior2@gmail.com", "12345678"));
        users.add(new User(94, "frostreaper2", "25.11.1957", R.drawable.avatar_4, 4, "Madison Howard", "frostreaper2@gmail.com", "12345678"));
        users.add(new User(95, "shadowflame2", "08.04.1956", R.drawable.avatar_5, 5, "Oliver Russell", "shadowflame2@gmail.com", "12345678"));
        users.add(new User(96, "darkrider2", "16.08.1955", R.drawable.avatar_6, 6, "Chloe Baker", "darkrider2@gmail.com", "12345678"));
        users.add(new User(97, "stormhunter3", "01.12.1954", R.drawable.avatar_7, 7, "Michael Bennett", "stormhunter3@gmail.com", "12345678"));
        users.add(new User(98, "frostmage3", "11.06.1953", R.drawable.avatar_8, 8, "Emma Peterson", "frostmage3@gmail.com", "12345678"));
        users.add(new User(99, "shadowwarrior3", "23.09.1952", R.drawable.avatar_9, 9, "William Murphy", "shadowwarrior3@gmail.com", "12345678"));
        users.add(new User(100, "nightfall3", "07.03.1951", R.drawable.avatar_10, 10, "Ava Bell", "nightfall3@gmail.com", "12345678"));
        users.add(new User(101, "crimsonfire3", "12.07.1950", R.drawable.avatar_11, 1, "Liam Morgan", "crimsonfire3@gmail.com", "12345678"));
        users.add(new User(102, "frostphoenix3", "25.11.1949", R.drawable.avatar_12, 2, "Isabella Bailey", "frostphoenix3@gmail.com", "12345678"));
        users.add(new User(103, "darkshadow3", "08.04.1948", R.drawable.avatar_13, 3, "James Cooper", "darkshadow3@gmail.com", "12345678"));
        users.add(new User(104, "stormrage3", "16.08.1947", R.drawable.avatar_14, 4, "Emily Green", "stormrage3@gmail.com", "12345678"));
        users.add(new User(105, "shadowknight3", "01.12.1946", R.drawable.avatar_15, 5, "Alexander Ward", "shadowknight3@gmail.com", "12345678"));
        users.add(new User(106, "frostwarrior3", "11.06.1945", R.drawable.avatar_16, 6, "Olivia Phillips", "frostwarrior3@gmail.com", "12345678"));
        users.add(new User(107, "phoenixrider3", "23.09.1944", R.drawable.avatar_17, 7, "Mason Mitchell", "phoenixrider3@gmail.com", "12345678"));
        users.add(new User(108, "shadowdancer3", "07.03.1943", R.drawable.avatar_18, 8, "Charlotte Campbell", "shadowdancer3@gmail.com", "12345678"));
        users.add(new User(109, "darkwarrior3", "12.07.1942", R.drawable.avatar_19, 9, "Lucas Carter", "darkwarrior3@gmail.com", "12345678"));
        users.add(new User(110, "frostreaper3", "25.11.1941", R.drawable.avatar_20, 10, "Amelia Roberts", "frostreaper3@gmail.com", "12345678"));
        users.add(new User(111, "shadowflame3", "08.04.1940", R.drawable.avatar_21, 1, "Benjamin Evans", "shadowflame3@gmail.com", "12345678"));
        users.add(new User(112, "darkrider3", "16.08.1939", R.drawable.avatar_22, 2, "Sophie Henderson", "darkrider3@gmail.com", "12345678"));
        users.add(new User(113, "stormhunter4", "01.12.1938", R.drawable.avatar_23, 3, "Daniel Collins", "stormhunter4@gmail.com", "12345678"));
        users.add(new User(114, "frostmage4", "11.06.1937", R.drawable.avatar_24, 4, "Grace Price", "frostmage4@gmail.com", "12345678"));
        users.add(new User(115, "shadowwarrior4", "23.09.1936", R.drawable.avatar_25, 5, "Henry Reed", "shadowwarrior4@gmail.com", "12345678"));
        users.add(new User(116, "nightfall4", "07.03.1935", R.drawable.avatar_26, 6, "Madison Howard", "nightfall4@gmail.com", "12345678"));
        users.add(new User(117, "crimsonfire4", "12.07.1934", R.drawable.avatar_27, 7, "Oliver Russell", "crimsonfire4@gmail.com", "12345678"));
        users.add(new User(118, "frostphoenix4", "25.11.1933", R.drawable.avatar_28, 8, "Chloe Baker", "frostphoenix4@gmail.com", "12345678"));
        users.add(new User(119, "darkshadow4", "08.04.1932", R.drawable.avatar_29, 9, "Michael Bennett", "darkshadow4@gmail.com", "12345678"));
        users.add(new User(120, "stormrage4", "16.08.1931", R.drawable.avatar_30, 10, "Emma Peterson", "stormrage4@gmail.com", "12345678"));
        users.add(new User(121, "shadowknight4", "01.12.1930", R.drawable.avatar_31, 1, "William Murphy", "shadowknight4@gmail.com", "12345678"));
        users.add(new User(122, "frostwarrior4", "11.06.1929", R.drawable.avatar_32, 2, "Ava Bell", "frostwarrior4@gmail.com", "12345678"));
        users.add(new User(123, "phoenixrider4", "23.09.1928", R.drawable.avatar_33, 3, "Liam Morgan", "phoenixrider4@gmail.com", "12345678"));
        users.add(new User(124, "shadowdancer4", "07.03.1927", R.drawable.avatar_34, 4, "Isabella Bailey", "shadowdancer4@gmail.com", "12345678"));
        users.add(new User(125, "darkwarrior4", "12.07.1926", R.drawable.avatar_35, 5, "James Cooper", "darkwarrior4@gmail.com", "12345678"));
        users.add(new User(126, "frostreaper4", "25.11.1925", R.drawable.avatar_36, 6, "Emily Green", "frostreaper4@gmail.com", "12345678"));
        users.add(new User(127, "shadowflame4", "08.04.1924", R.drawable.avatar_37, 7, "Alexander Ward", "shadowflame4@gmail.com", "12345678"));
        users.add(new User(128, "darkrider4", "16.08.1923", R.drawable.avatar_38, 8, "Olivia Phillips", "darkrider4@gmail.com", "12345678"));
        users.add(new User(129, "stormhunter5", "01.12.1922", R.drawable.avatar_39, 9, "Mason Mitchell", "stormhunter5@gmail.com", "12345678"));
        users.add(new User(130, "frostmage5", "11.06.1921", R.drawable.avatar_40, 10, "Charlotte Campbell", "frostmage5@gmail.com", "12345678"));
        users.add(new User(131, "shadowwarrior5", "23.09.1920", R.drawable.avatar_1, 1, "Lucas Carter", "shadowwarrior5@gmail.com", "12345678"));
        users.add(new User(132, "nightfall5", "07.03.1919", R.drawable.avatar_2, 2, "Amelia Roberts", "nightfall5@gmail.com", "12345678"));
        users.add(new User(133, "crimsonfire5", "12.07.1918", R.drawable.avatar_3, 3, "Benjamin Evans", "crimsonfire5@gmail.com", "12345678"));
        users.add(new User(134, "frostphoenix5", "25.11.1917", R.drawable.avatar_4, 4, "Sophie Henderson", "frostphoenix5@gmail.com", "12345678"));
        users.add(new User(135, "darkshadow5", "08.04.1916", R.drawable.avatar_5, 5, "Daniel Collins", "darkshadow5@gmail.com", "12345678"));
        users.add(new User(136, "stormrage5", "16.08.1915", R.drawable.avatar_6, 6, "Grace Price", "stormrage5@gmail.com", "12345678"));
        users.add(new User(137, "shadowknight5", "01.12.1914", R.drawable.avatar_7, 7, "Henry Reed", "shadowknight5@gmail.com", "12345678"));
        users.add(new User(138, "frostwarrior5", "11.06.1913", R.drawable.avatar_8, 8, "Madison Howard", "frostwarrior5@gmail.com", "12345678"));
        users.add(new User(139, "phoenixrider5", "23.09.1912", R.drawable.avatar_9, 9, "Oliver Russell", "phoenixrider5@gmail.com", "12345678"));
        users.add(new User(140, "shadowdancer5", "07.03.1911", R.drawable.avatar_10, 10, "Chloe Baker", "shadowdancer5@gmail.com", "12345678"));
        users.add(new User(141, "darkwarrior5", "12.07.1910", R.drawable.avatar_11, 1, "Michael Bennett", "darkwarrior5@gmail.com", "12345678"));
        users.add(new User(142, "frostreaper5", "25.11.1909", R.drawable.avatar_12, 2, "Emma Peterson", "frostreaper5@gmail.com", "12345678"));
        users.add(new User(143, "shadowflame5", "08.04.1908", R.drawable.avatar_13, 3, "William Murphy", "shadowflame5@gmail.com", "12345678"));
        users.add(new User(144, "darkrider5", "16.08.1907", R.drawable.avatar_14, 4, "Ava Bell", "darkrider5@gmail.com", "12345678"));
        users.add(new User(145, "stormhunter6", "01.12.1906", R.drawable.avatar_15, 5, "Liam Morgan", "stormhunter6@gmail.com", "12345678"));
        users.add(new User(146, "frostmage6", "11.06.1905", R.drawable.avatar_16, 6, "Isabella Bailey", "frostmage6@gmail.com", "12345678"));
        users.add(new User(147, "shadowwarrior6", "23.09.1904", R.drawable.avatar_17, 7, "James Cooper", "shadowwarrior6@gmail.com", "12345678"));
        users.add(new User(148, "nightfall6", "07.03.1903", R.drawable.avatar_18, 8, "Emily Green", "nightfall6@gmail.com", "12345678"));
        users.add(new User(149, "crimsonfire6", "12.07.1902", R.drawable.avatar_19, 9, "Alexander Ward", "crimsonfire6@gmail.com", "12345678"));
        users.add(new User(150, "frostphoenix6", "25.11.1901", R.drawable.avatar_20, 10, "Olivia Phillips", "frostphoenix6@gmail.com", "12345678"));

        return users;
    }

    public static ArrayList<Library> generateDummyLibrary() {
        ArrayList<Library> libraries = new ArrayList<>();

        libraries.add(new Library(1, 1, 11426, "library"));
        libraries.add(new Library(2, 1, 55057, "library"));
        libraries.add(new Library(3, 1, 143114, "wishlist"));
        libraries.add(new Library(4, 1, 75235, "wishlist"));
        libraries.add(new Library(5, 1, 151665, "wishlist"));
        libraries.add(new Library(6, 1, 217590, "wishlist"));
        libraries.add(new Library(7, 1, 20228, "playing"));
        libraries.add(new Library(8, 1, 1942, "playing"));
        libraries.add(new Library(9, 1, 1020, "playing"));
        libraries.add(new Library(10, 1, 11397, "playing"));
        libraries.add(new Library(11, 1, 5606, "pause"));
        libraries.add(new Library(12, 1, 1369, "pause"));
        libraries.add(new Library(13, 1, 536, "pause"));
        libraries.add(new Library(14, 1, 1833, "pause"));
        libraries.add(new Library(15, 1, 37034, "completed"));
        libraries.add(new Library(16, 1, 16992, "completed"));
        libraries.add(new Library(17, 1, 16992, "completed"));
        libraries.add(new Library(18, 1, 3025, "completed"));
        libraries.add(new Library(19, 1, 27421, "completed"));

        return libraries;
    }
}