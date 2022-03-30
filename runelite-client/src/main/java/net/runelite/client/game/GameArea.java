package net.runelite.client.game;

import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;

@Getter
public enum GameArea
{
	// Bosses
	BOSS_ABYSSAL_SIRE("Abyssal Sire", GameAreaType.BOSSES, 11851, 11850, 12363, 12362),
	BOSS_CERBERUS("Cerberus", GameAreaType.BOSSES, 4883, 5140, 5395),
	BOSS_COMMANDER_ZILYANA("Commander Zilyana", GameAreaType.BOSSES, new RegionArea(11602, new WorldPoint(2889, 5258, 0), new WorldPoint(2907, 5275, 0))),
	BOSS_CORP("Corporeal Beast", GameAreaType.BOSSES, 11842, 11844),
	BOSS_DKS("Dagannoth Kings", GameAreaType.BOSSES, 11588, 11589),
	BOSS_DUKE_SUCELLUS("Duke Sucellus", GameAreaType.BOSSES, 12132),
	BOSS_GENERAL_GRAARDOR("General Graardor", GameAreaType.BOSSES, new RegionArea(11347, new WorldPoint(2864, 5351, 2), new WorldPoint(2876, 5369, 2))),
	BOSS_GIANT_MOLE("Giant Mole", GameAreaType.BOSSES, 6993, 6992),
	BOSS_GROTESQUE_GUARDIANS("Grotesque Guardians", GameAreaType.BOSSES, 6727),
	BOSS_HESPORI("Hespori", GameAreaType.BOSSES, 5021),
	BOSS_HYDRA("Alchemical Hydra", GameAreaType.BOSSES, 5536),
	BOSS_KQ("Kalphite Queen", GameAreaType.BOSSES, 13972),
	BOSS_KRAKEN("Kraken", GameAreaType.BOSSES, 9116),
	BOSS_KREEARRA("Kree'arra", GameAreaType.BOSSES, new RegionArea(11346, new WorldPoint(2824, 5296, 2), new WorldPoint(2842, 5308, 2))),
	BOSS_KRIL_TSUTSAROTH("K'ril Tsutsaroth", GameAreaType.BOSSES, new RegionArea(11603, new WorldPoint(2918, 5318, 2), new WorldPoint(2936, 5333, 2))),
	BOSS_NEX("Nex", GameAreaType.BOSSES, 11601),
	BOSS_NIGHTMARE("Nightmare of Ashihama", GameAreaType.BOSSES, 15515),
	BOSS_PHANTOM_MUSPAH("Phantom Muspah", GameAreaType.BOSSES, 11330),
	BOSS_SARACHNIS("Sarachnis", GameAreaType.BOSSES, 7322),
	BOSS_SKOTIZO("Skotizo", GameAreaType.BOSSES, 6810),
	BOSS_SMOKE_DEVIL("Thermonuclear smoke devil", GameAreaType.BOSSES, 9363, 9619),
	BOSS_TEMPOROSS("Tempoross", GameAreaType.BOSSES, 12078),
	BOSS_THE_LEVIATHAN("The Leviathan", GameAreaType.BOSSES, 8291),
	BOSS_THE_WHISPERER("The Whisperer", GameAreaType.BOSSES, 10595),
	BOSS_VARDORVIS("Vardorvis", GameAreaType.BOSSES, 4405),
	BOSS_VORKATH("Vorkath", GameAreaType.BOSSES, 9023),
	BOSS_WINTERTODT("Wintertodt", GameAreaType.BOSSES, 6462),
	BOSS_ZALCANO("Zalcano", GameAreaType.BOSSES, 12126),
	BOSS_ZULRAH("Zulrah", GameAreaType.BOSSES, 9007),

	// Cities
	CITY_AL_KHARID("Al Kharid", GameAreaType.CITIES, 13105, 13106),
	CITY_ARCEUUS_HOUSE("Arceuus", GameAreaType.CITIES, 6458, 6459, 6460, 6714, 6715),
	CITY_ARDOUGNE("Ardougne", GameAreaType.CITIES, 9779, 9780, 10035, 10036, 10291, 10292, 10547, 10548),
	CITY_BANDIT_CAMP("Bandit Camp", GameAreaType.CITIES, 12590),
	CITY_BARBARIAN_OUTPOST("Barbarian Outpost", GameAreaType.CITIES, 10039),
	CITY_BARBARIAN_VILLAGE("Barbarian Village", GameAreaType.CITIES, 12341),
	CITY_BEDABIN_CAMP("Bedabin Camp", GameAreaType.CITIES, 12591),
	CITY_BRIMHAVEN("Brimhaven", GameAreaType.CITIES, 11057, 11058),
	CITY_BURGH_DE_ROTT("Burgh de Rott", GameAreaType.CITIES, 13874, 13873, 14130, 14129),
	CITY_BURTHORPE("Burthorpe", GameAreaType.CITIES, 11319, 11575),
	CITY_CAM_TORUM("Cam Torum", GameAreaType.CITIES, 5525, 5780, 5781, 6037),
	CITY_CANIFIS("Canifis", GameAreaType.CITIES, 13878),
	CITY_CATHERBY("Catherby", GameAreaType.CITIES, 11317, 11318, 11061),
	CITY_CIVITAS_ILLA_FORTIS("Civitas Illa Fortis", GameAreaType.CITIES, 6448, 6449, 6704, 6705, 6960, 6961),
	CITY_CORSAIR_COVE("Corsair Cove", GameAreaType.CITIES, 10028, 10284),
	CITY_DARKMEYER("Darkmeyer", GameAreaType.CITIES, 14388, 14644),
	CITY_DORGESH_KAAN("Dorgesh-Kaan", GameAreaType.CITIES, 10835, 10834),
	CITY_DRAYNOR("Draynor", GameAreaType.CITIES, 12338, 12339),
	CITY_EDGEVILLE("Edgeville", GameAreaType.CITIES, 12342),
	CITY_ENTRANA("Entrana", GameAreaType.CITIES, 11060, 11316),
	CITY_ETCETERIA("Etceteria", GameAreaType.CITIES, 10300),
	CITY_FALADOR("Falador", GameAreaType.CITIES, 11828, 11572, 11827, 12084),
	CITY_GUTANOTH("Gu'Tanoth", GameAreaType.CITIES, 10031),
	CITY_GWENITH("Gwenith", GameAreaType.CITIES, 8757),
	CITY_HOSIDIUS_HOUSE("Hosidius", GameAreaType.CITIES, 6710, 6711, 6712, 6455, 6456, 6966, 6967, 6968, 7221, 7223, 7224, 7478, 7479),
	CITY_JATIZSO("Jatizso", GameAreaType.CITIES, 9531),
	CITY_KELDAGRIM("Keldagrim", GameAreaType.CITIES, 11423, 11422, 11679, 11678),
	CITY_LANDS_END("Land's End", GameAreaType.CITIES, 5941),
	CITY_LASSAR_UNDERCITY("Lassar Undercity", GameAreaType.CITIES, 9314, 9315, 9316, 9571, 9572, 9828, 10338, 10339, 10340, 10596, 10852),
	CITY_LLETYA("Lletya", GameAreaType.CITIES, 9265, 11103),
	CITY_LOVAKENGJ_HOUSE("Lovakengj", GameAreaType.CITIES, 5692, 5691, 5947, 6203, 6202, 5690, 5946),
	CITY_LUMBRIDGE("Lumbridge", GameAreaType.CITIES, 12850),
	CITY_LUNAR_ISLE("Lunar Isle", GameAreaType.CITIES, 8253, 8252, 8509, 8508),
	CITY_MARIM("Marim", GameAreaType.REGIONS, 11051),
	CITY_MEIYERDITCH("Meiyerditch", GameAreaType.CITIES, 14132, 14387, 14386, 14385),
	CITY_MENAPHOS("Menaphos", GameAreaType.CITIES, 12843),
	CITY_MISCELLANIA("Miscellania", GameAreaType.CITIES, 10044),
	CITY_MOR_UL_REK("Mor Ul Rek", GameAreaType.CITIES, 9808, 9807, 10064, 10063),
	CITY_MORTTON("Mort'ton", GameAreaType.CITIES, 13875),
	CITY_MOS_LE_HARMLESS("Mos Le'Harmless", GameAreaType.CITIES, 14637, 14638, 14639, 14894, 14895, 15151, 15406, 15407),
	CITY_MOUNT_KARUULM("Mount Karuulm", GameAreaType.CITIES, 5179, 4923, 5180),
	CITY_MOUNTAIN_CAMP("Mountain Camp", GameAreaType.CITIES, 11065),
	CITY_MYNYDD("Mynydd", GameAreaType.CITIES, 8501),
	CITY_NARDAH("Nardah", GameAreaType.CITIES, 13613),
	CITY_NEITIZNOT("Neitiznot", GameAreaType.CITIES, 9275),
	CITY_PISCARILIUS_HOUSE("Port Piscarilius", GameAreaType.CITIES, 6969, 6971, 7227, 6970, 7225, 7226),
	CITY_PISCATORIS("Piscatoris", GameAreaType.CITIES, 9273),
	CITY_POLLNIVNEACH("Pollnivneach", GameAreaType.CITIES, 13358),
	CITY_PORT_KHAZARD("Port Khazard", GameAreaType.CITIES, 10545),
	CITY_PORT_PHASMATYS("Port Phasmatys", GameAreaType.CITIES, 14646),
	CITY_PORT_SARIM("Port Sarim", GameAreaType.CITIES, 12081, 12082),
	CITY_PRIFDDINAS("Prifddinas", GameAreaType.CITIES, 8499, 8500, 8755, 8756, 9011, 9012, 9013, 12894, 12895, 13150, 13151),
	CITY_RELLEKKA("Rellekka", GameAreaType.CITIES, 10297, 10553),
	CITY_RIMMINGTON("Rimmington", GameAreaType.CITIES, 11826, 11570),
	CITY_SEERS_VILLAGE("Seers' Village", GameAreaType.CITIES, 10806),
	CITY_SHAYZIEN_HOUSE("Shayzien", GameAreaType.CITIES, 5944, 5943, 6200, 6199, 5686, 5687, 5688, 5689, 5945),
	CITY_SHILO_VILLAGE("Shilo Village", GameAreaType.CITIES, 11310),
	CITY_SLEPE("Slepe", GameAreaType.CITIES, 14643, 14899, 14900, 14901),
	CITY_SOPHANEM("Sophanem", GameAreaType.CITIES, 13099),
	CITY_TAI_BWO_WANNAI("Tai Bwo Wannai", GameAreaType.CITIES, 11056, 11055),
	CITY_TAVERLEY("Taverley", GameAreaType.CITIES, 11574, 11573),
	CITY_TREE_GNOME_STRONGHOLD("Tree Gnome Stronghold", GameAreaType.CITIES,
		regionGameAreas(9525, 9526, 9782, 9781),
		new RegionArea(9527, new WorldPoint(2374, 3520, 0), new WorldPoint(2399, 3537, 0)),
		new RegionArea(9527, new WorldPoint(2400, 3520, 0), new WorldPoint(2431, 3550, 0))),
	CITY_TREE_GNOME_VILLAGE("Tree Gnome Village", GameAreaType.CITIES, 10033),
	CITY_TROLL_STRONGHOLD("Troll Stronghold", GameAreaType.CITIES, 11321, 11421),
	CITY_UZER("Uzer", GameAreaType.CITIES, 13872),
	CITY_UZER_OASIS("Uzer Oasis", GameAreaType.CITIES, 13871),
	CITY_VARROCK("Varrock", GameAreaType.CITIES, 12596, 12597, 12852, 12853, 12854, 13108, 13109, 13110),
	CITY_VER_SINHAZA("Ver Sinhaza", GameAreaType.CITIES, 14642),
	CITY_VOID_OUTPOST("Void Knights' Outpost", GameAreaType.CITIES, 10537),
	CITY_WEISS("Weiss", GameAreaType.CITIES, 11325, 11581),
	CITY_WITCHHAVEN("Witchaven", GameAreaType.CITIES, 10803),
	CITY_YANILLE("Yanille", GameAreaType.CITIES, 10288, 10032),
	CITY_ZANARIS("Zanaris", GameAreaType.CITIES, 9285, 9541, 9540, 9797),
	CITY_ZULANDRA("Zul-Andra", GameAreaType.CITIES, 8495, 8751),

	// Dungeons
	DUNGEON_ABANDONED_MINE("Abandoned Mine", GameAreaType.DUNGEONS, 13618, 13718, 11079, 11078, 11077, 10823, 10822, 10821),
	DUNGEON_AH_ZA_RHOON("Ah Za Rhoon", GameAreaType.DUNGEONS, 11666),
	DUNGEON_ANCIENT_CAVERN("Ancient Cavern", GameAreaType.DUNGEONS, 6483, 6995),
	DUNGEON_APE_ATOLL("Ape Atoll Dungeon", GameAreaType.DUNGEONS, 11150, 10894),
	DUNGEON_APE_ATOLL_BANANA_PLANTATION("Ape Atoll Banana Plantation", GameAreaType.DUNGEONS, 10895),
	DUNGEON_ARDY_BASEMENT("West Ardougne Basement", GameAreaType.DUNGEONS, 10135),
	DUNGEON_ARDY_SEWERS("Ardougne Sewers", GameAreaType.DUNGEONS, 10134, 10136, 10391, 10647),
	DUNGEON_ASGARNIAN_ICE_CAVES("Asgarnian Ice Caves", GameAreaType.DUNGEONS, 11925, 12181),
	DUNGEON_BERVIRIUS_TOMB("Tomb of Bervirius", GameAreaType.DUNGEONS, 11154),
	DUNGEON_BRIMHAVEN("Brimhaven Dungeon", GameAreaType.DUNGEONS, 10901, 10900, 10899, 10645, 10644, 10643),
	DUNGEON_BRINE_RAT_CAVERN("Brine Rat Cavern", GameAreaType.DUNGEONS, 10910),
	DUNGEON_CATACOMBS_OF_KOUREND("Catacombs of Kourend", GameAreaType.DUNGEONS, 6557, 6556, 6813, 6812),
	DUNGEON_CHAMPIONS_CHALLENGE("Champions' Challenge", GameAreaType.DUNGEONS, 12696),
	DUNGEON_CHAOS_DRUID_TOWER("Chaos Druid Tower", GameAreaType.DUNGEONS, 10392),
	DUNGEON_CHASM_OF_FIRE("Chasm of Fire", GameAreaType.DUNGEONS, 5789),
	DUNGEON_CHASM_OF_TEARS("Chasm of Tears", GameAreaType.DUNGEONS, 12948),
	DUNGEON_CHINCHOMPA("Chinchompa Hunting Ground", GameAreaType.DUNGEONS, 10129),
	DUNGEON_CIVITAS_ILLA_FORTIS("Civitas illa Fortis Underground", GameAreaType.DUNGEONS, 6549, 6804, 6805),
	DUNGEON_CLOCK_TOWER("Clock Tower Basement", GameAreaType.DUNGEONS, 10390),
	DUNGEON_CORSAIR_COVE("Corsair Cove Dungeon", GameAreaType.DUNGEONS, 8076, 8332),
	DUNGEON_CRABCLAW_CAVES("Crabclaw Caves", GameAreaType.DUNGEONS, 6553, 6809),
	DUNGEON_CRANDOR("Crandor Dungeon", GameAreaType.DUNGEONS, 11414),
	DUNGEON_CRASH_SITE_CAVERN("Crash Site Cavern", GameAreaType.DUNGEONS, 8280, 8536),
	DUNGEON_CRUMBLING_TOWER("Crumbling Tower", GameAreaType.DUNGEONS, 7827),
	DUNGEON_DAEYALT_ESSENCE_MINE("Daeyalt Essence Mine", GameAreaType.DUNGEONS, 14744),
	DUNGEON_DIGSITE("Digsite Dungeon", GameAreaType.DUNGEONS,
		regionGameAreas(13464, 13465),
		new RegionArea(13621, new WorldPoint(3392, 3392, 0), new WorldPoint(3401, 3455, 0)),
		new RegionArea(13621, new WorldPoint(3402, 3410, 0), new WorldPoint(3405, 3419, 0)),
		new RegionArea(13621, new WorldPoint(3402, 3434, 0), new WorldPoint(3403, 3439, 0))),
	DUNGEON_DORGESHKAAN("Dorgesh-Kaan South Dungeon", GameAreaType.DUNGEONS, 10833),
	DUNGEON_DORGESHUUN_MINES("Dorgeshuun Mines", GameAreaType.DUNGEONS, 12950, 13206),
	DUNGEON_DRAYNOR_SEWERS("Draynor Sewers", GameAreaType.DUNGEONS, 12439, 12438),
	DUNGEON_DWARVEN_MINES("Dwarven Mines", GameAreaType.DUNGEONS, 12185, 12184, 12183),
	DUNGEON_EAGLES_PEAK("Eagles' Peak Dungeon", GameAreaType.DUNGEONS, 8013),
	DUNGEON_ECTOFUNTUS("Ectofuntus", GameAreaType.DUNGEONS, 14746),
	DUNGEON_EDGEVILLE("Edgeville Dungeon", GameAreaType.DUNGEONS, 12441, 12442, 12443, 12698),
	DUNGEON_ELEMENTAL_WORKSHOP("Elemental Workshop", GameAreaType.DUNGEONS, 10906, 7760),
	DUNGEON_ELVEN_RABBIT_CAVE("Elven rabbit cave", GameAreaType.DUNGEONS, 13252),
	DUNGEON_ENAKHRAS_TEMPLE("Enakhra's Temple", GameAreaType.DUNGEONS, 12423),
	DUNGEON_EVIL_CHICKENS_LAIR("Evil Chicken's Lair", GameAreaType.DUNGEONS, 9796),
	DUNGEON_EXPERIMENT_CAVE("Experiment Cave", GameAreaType.DUNGEONS, 14235, 13979),
	DUNGEON_FEROX_ENCLAVE("Ferox Enclave Dungeon", GameAreaType.DUNGEONS, 12700),
	DUNGEON_FORTHOS("Forthos Dungeon", GameAreaType.DUNGEONS, 7323),
	DUNGEON_FREMENNIK_SLAYER("Fremennik Slayer Dungeon", GameAreaType.DUNGEONS, 10907, 10908, 11164),
	DUNGEON_GLARIALS_TOMB("Glarial's Tomb", GameAreaType.DUNGEONS, 10137),
	DUNGEON_GOBLIN_CAVE("Goblin Cave", GameAreaType.DUNGEONS, 10393),
	DUNGEON_GRAND_TREE_TUNNELS("Grand Tree Tunnels", GameAreaType.DUNGEONS, 9882),
	DUNGEON_HAM_HIDEOUT("H.A.M. Hideout", GameAreaType.DUNGEONS, 12694),
	DUNGEON_HAM_STORE_ROOM("H.A.M. Store room", GameAreaType.DUNGEONS, 10321),
	DUNGEON_HEROES_GUILD("Heroes' Guild Mine", GameAreaType.DUNGEONS, 11674),
	DUNGEON_IORWERTH("Iorwerth Dungeon", GameAreaType.DUNGEONS, 12737, 12738, 12993, 12994),
	DUNGEON_ISLE_OF_SOULS("Isle of Souls Dungeon", GameAreaType.DUNGEONS, 8593),
	DUNGEON_JATIZSO_MINES("Jatizso Mines", GameAreaType.DUNGEONS, 9631),
	DUNGEON_JIGGIG_BURIAL_TOMB("Jiggig Burial Tomb", GameAreaType.DUNGEONS, 9875, 9874),
	DUNGEON_JOGRE("Jogre Dungeon", GameAreaType.DUNGEONS, 11412),
	DUNGEON_KARAMJA("Karamja Dungeon", GameAreaType.DUNGEONS, 11413),
	DUNGEON_KARUULM("Karuulm Slayer Dungeon", GameAreaType.DUNGEONS, 5280, 5279, 5023, 5535, 5022, 4766, 4510, 4511, 4767, 4768, 4512),
	DUNGEON_KGP_HEADQUARTERS("KGP Headquarters", GameAreaType.DUNGEONS, 10658),
	DUNGEON_KRUK("Kruk's Dungeon", GameAreaType.DUNGEONS, 9358, 9359, 9360, 9615, 9616, 9871, 10125, 10126, 10127, 10128, 10381, 10382, 10383, 10384, 10637, 10638, 10639, 10640),
	DUNGEON_LEGENDS_GUILD("Legends' Guild Dungeon", GameAreaType.DUNGEONS, 10904),
	DUNGEON_LIGHTHOUSE("Lighthouse", GameAreaType.DUNGEONS, 10140),
	DUNGEON_LIZARDMAN_CAVES("Lizardman Caves", GameAreaType.DUNGEONS, 5275),
	DUNGEON_LIZARDMAN_TEMPLE("Lizardman Temple", GameAreaType.DUNGEONS, 5277),
	DUNGEON_LUMBRIDGE_SWAMP_CAVES("Lumbridge Swamp Caves", GameAreaType.DUNGEONS, 12693, 12949),
	DUNGEON_LUNAR_ISLE_MINE("Lunar Isle Mine", GameAreaType.DUNGEONS, 9377),
	DUNGEON_MANIACAL_HUNTER("Maniacal Monkey Hunter Area", GameAreaType.DUNGEONS, 11662),
	DUNGEON_MEIYERDITCH_MINE("Meiyerditch Mine", GameAreaType.DUNGEONS, 9544),
	DUNGEON_MISCELLANIA("Miscellania Dungeon", GameAreaType.DUNGEONS, 10144, 10400),
	DUNGEON_MOGRE_CAMP("Mogre Camp", GameAreaType.DUNGEONS, 11924),
	DUNGEON_MOS_LE_HARMLESS_CAVES("Mos Le'Harmless Caves", GameAreaType.DUNGEONS, 14994, 14995, 15251),
	DUNGEON_MOTHERLODE_MINE("Motherlode Mine", GameAreaType.DUNGEONS, 14679, 14680, 14681, 14935, 14936, 14937, 15191, 15192, 15193),
	DUNGEON_MOURNER_TUNNELS("Mourner Tunnels", GameAreaType.DUNGEONS, 7752, 8008),
	DUNGEON_MOUSE_HOLE("Mouse Hole", GameAreaType.DUNGEONS, 9046),
	DUNGEON_MYREDITCH_LABORATORIES("Myreditch Laboratories", GameAreaType.DUNGEONS, 14232, 14233, 14487, 14488),
	DUNGEON_MYREQUE("Myreque Hideout", GameAreaType.DUNGEONS, 13721, 13974, 13977, 13978),
	DUNGEON_MYTHS_GUILD("Myths' Guild Dungeon", GameAreaType.DUNGEONS, 7564, 7820, 7821),
	DUNGEON_OBSERVATORY("Observatory Dungeon", GameAreaType.DUNGEONS, 9362),
	DUNGEON_OGRE_ENCLAVE("Ogre Enclave", GameAreaType.DUNGEONS, 10387),
	DUNGEON_OURANIA("Ourania Cave", GameAreaType.DUNGEONS, 12119),
	DUNGEON_QUIDAMORTEM_CAVE("Quidamortem Cave", GameAreaType.DUNGEONS, 4763),
	DUNGEON_RASHILIYIAS_TOMB("Rashiliyta's Tomb", GameAreaType.DUNGEONS, 11668),
	DUNGEON_RUINS_OF_CAMDOZAAL("Ruins of Camdozaal", GameAreaType.DUNGEONS, 11609, 11610, 11611, 11865, 11866, 11867, 12121, 12122, 12123),
	DUNGEON_SALT_MINE("Salt Mine", GameAreaType.DUNGEONS, 11425),
	DUNGEON_SARADOMINSHRINE("Saradomin Shrine (Paterdomus)", GameAreaType.DUNGEONS, 13722),
	DUNGEON_SHADE_CATACOMBS("Shade Catacombs", GameAreaType.DUNGEONS, 13975),
	DUNGEON_SHADOW("Shadow Dungeon", GameAreaType.DUNGEONS, 10575, 10831),
	DUNGEON_SHAYZIEN_CRYPTS("Shayzien Crypts", GameAreaType.DUNGEONS, 6043),
	DUNGEON_SISTERHOOD_SANCTUARY("Sisterhood Sanctuary", GameAreaType.DUNGEONS, 14999, 15000, 15001, 15255, 15256, 15257, 15511, 15512, 15513),
	DUNGEON_SMOKE("Smoke Dungeon", GameAreaType.DUNGEONS, 12946, 13202),
	DUNGEON_SOPHANEM("Sophanem Dungeon", GameAreaType.DUNGEONS, 13200),
	DUNGEON_SOURHOG_CAVE("Sourhog Cave", GameAreaType.DUNGEONS, 12695),
	DUNGEON_STRONGHOLD_SECURITY("Stronghold of Security", GameAreaType.DUNGEONS, 7505, 8017, 8530, 9297),
	DUNGEON_STRONGHOLD_SLAYER("Stronghold Slayer Cave", GameAreaType.DUNGEONS, 9624, 9625, 9880, 9881),
	DUNGEON_TARNS_LAIR("Tarn's Lair", GameAreaType.DUNGEONS, 12616, 12615),
	DUNGEON_TAVERLEY("Taverley Dungeon", GameAreaType.DUNGEONS, 11416, 11417, 11671, 11672, 11673, 11928, 11929),
	DUNGEON_TEMPLE_OF_IKOV("Temple of Ikov", GameAreaType.DUNGEONS, 10649, 10905, 10650),
	DUNGEON_TEMPLE_OF_LIGHT("Temple of Light", GameAreaType.DUNGEONS, 7496),
	DUNGEON_TEMPLE_OF_MARIMBO("Temple of Marimbo", GameAreaType.DUNGEONS, 11151),
	DUNGEON_THE_BURROW("The Burrow", GameAreaType.DUNGEONS, 6291),
	DUNGEON_THE_WARRENS("The Warrens", GameAreaType.DUNGEONS, 7070, 7326),
	DUNGEON_TOLNA("Dungeon of Tolna", GameAreaType.DUNGEONS, 13209),
	DUNGEON_TOWER_OF_LIFE("Tower of Life Basement", GameAreaType.DUNGEONS, 12100),
	DUNGEON_TRAHAEARN_MINE("Trahaearn Mine", GameAreaType.DUNGEONS, 13250),
	DUNGEON_TUNNEL_OF_CHAOS("Tunnel of Chaos", GameAreaType.DUNGEONS, 12625),
	DUNGEON_UNDERGROUND_PASS("Underground Pass", GameAreaType.DUNGEONS, 9369, 9370),
	DUNGEON_VARROCKSEWERS("Varrock Sewers", GameAreaType.DUNGEONS, 12954, 13210),
	DUNGEON_VIYELDI_CAVES("Viyeldi Caves", GameAreaType.DUNGEONS, 9545, 11153),
	DUNGEON_WARRIORS_GUILD("Warriors' Guild Basement", GameAreaType.DUNGEONS, 11675),
	DUNGEON_WATER_RAVINE("Water Ravine", GameAreaType.DUNGEONS, 13461),
	DUNGEON_WATERBIRTH("Waterbirth Dungeon", GameAreaType.DUNGEONS, 9886, 10142, 7492, 7748),
	DUNGEON_WATERFALL("Waterfall Dungeon", GameAreaType.DUNGEONS, 10394),
	DUNGEON_WEREWOLF_AGILITY("Werewolf Agility Course", GameAreaType.DUNGEONS, 14234),
	DUNGEON_WHITE_WOLF_MOUNTAIN_CAVES("White Wolf Mountain Caves", GameAreaType.DUNGEONS, 11418, 11419),
	DUNGEON_WITCHAVEN_SHRINE("Witchhaven Shrine Dungeon", GameAreaType.DUNGEONS, 10903),
	DUNGEON_WIZARDS_TOWER("Wizards' Tower Basement", GameAreaType.DUNGEONS, 12437),
	DUNGEON_WOODCUTTING_GUILD("Woodcutting Guild Dungeon", GameAreaType.DUNGEONS, 6298),
	DUNGEON_WYVERN_CAVE("Wyvern Cave", GameAreaType.DUNGEONS, 14495, 14496),
	DUNGEON_YANILLE_AGILITY("Yanille Agility Dungeon", GameAreaType.DUNGEONS, 10388),

	// Minigames
	MG_ARDOUGNE_RAT_PITS("Ardougne Rat Pits", GameAreaType.MINIGAMES, 10646),
	MG_BARBARIAN_ASSAULT("Barbarian Assault", GameAreaType.MINIGAMES, 7508, 7509, 10322),
	MG_BARROWS("Barrows", GameAreaType.MINIGAMES, 14131, 14231),
	MG_BLAST_FURNACE("Blast Furnace", GameAreaType.MINIGAMES, 7757),
	MG_BRIMHAVEN_AGILITY_ARENA("Brimhaven Agility Arena", GameAreaType.MINIGAMES, 11157),
	MG_BURTHORPE_GAMES_ROOM("Burthorpe Games Room", GameAreaType.MINIGAMES, 8781),
	MG_CASTLE_WARS("Castle Wars", GameAreaType.MINIGAMES, 9520, 9620),
	MG_CLAN_WARS("Clan Wars", GameAreaType.MINIGAMES, 12621, 12622, 12623, 13130, 13131, 13133, 13134, 13135, 13386, 13387, 13390, 13641, 13642, 13643, 13644, 13645, 13646, 13647, 13899, 13900, 14155, 14156),
	MG_PVP_ARENA("PvP Arena", GameAreaType.MINIGAMES,
		regionGameAreas(13362, 13363),
		new RegionArea(13618, new WorldPoint(3392, 3200, 0), new WorldPoint(3405, 3263, 0))),
	MG_FISHING_TRAWLER("Fishing Trawler", GameAreaType.MINIGAMES, 7499),
	MG_FORTIS_COLOSSEUM("Fortis Colosseum", GameAreaType.MINIGAMES, 7216),
	MG_FORTIS_COLOSSEUM_LOBBY("Fortis Colosseum Lobby", GameAreaType.MINIGAMES, 7316),
	MG_GAUNTLET("The Gauntlet", GameAreaType.MINIGAMES, 12127, 7512),
	MG_CORRUPTED_GAUNTLET("Corrupted Gauntlet", GameAreaType.MINIGAMES, 7768),
	MG_GIANTS_FOUNDRY("Giants' Foundry", GameAreaType.MINIGAMES, 13491),
	MG_GUARDIANS_OF_THE_RIFT("Guardians of the Rift", GameAreaType.MINIGAMES, 14484),
	MG_HALLOWED_SEPULCHRE("Hallowed Sepulchre", GameAreaType.MINIGAMES, 8797, 9051, 9052, 9053, 9054, 9309, 9563, 9565, 9821, 10074, 10075, 10077),
	MG_INFERNO("The Inferno", GameAreaType.MINIGAMES, 9043),
	MG_KELDAGRIM_RAT_PITS("Keldagrim Rat Pits", GameAreaType.MINIGAMES, 7753),
	MG_LAST_MAN_STANDING_DESERTED_ISLAND("LMS - Deserted Island", GameAreaType.MINIGAMES, 13658, 13659, 13660, 13914, 13915, 13916),
	MG_LAST_MAN_STANDING_WILD_VARROCK("LMS - Wild Varrock", GameAreaType.MINIGAMES, 13918, 13919, 13920, 14174, 14175, 14176, 14430, 14431, 14432),
	MG_MAGE_TRAINING_ARENA("Mage Training Arena", GameAreaType.MINIGAMES, 13462, 13463),
	MG_NIGHTMARE_ZONE("Nightmare Zone", GameAreaType.MINIGAMES, 9033),
	MG_PEST_CONTROL("Pest Control", GameAreaType.MINIGAMES, 10536),
	MG_PORT_SARIM_RAT_PITS("Port Sarim Rat Pits", GameAreaType.MINIGAMES, 11926),
	MG_PYRAMID_PLUNDER("Pyramid Plunder", GameAreaType.MINIGAMES, 7749),
	MG_ROGUES_DEN("Rogues' Den", GameAreaType.MINIGAMES, 11854, 11855, 12109, 12110, 12111),
	MG_SORCERESS_GARDEN("Sorceress's Garden", GameAreaType.MINIGAMES, 11605),
	MG_SOUL_WARS("Soul Wars", GameAreaType.MINIGAMES, 8493, 8748, 8749, 9005),
	MG_TEMPLE_TREKKING("Temple Trekking", GameAreaType.MINIGAMES, 8014, 8270, 8256, 8782, 9038, 9294, 9550, 9806),
	MG_TITHE_FARM("Tithe Farm", GameAreaType.MINIGAMES, 7222),
	MG_TROUBLE_BREWING("Trouble Brewing", GameAreaType.MINIGAMES, 15150),
	MG_TZHAAR_FIGHT_CAVES("Tzhaar Fight Caves", GameAreaType.MINIGAMES, 9551),
	MG_TZHAAR_FIGHT_PITS("Tzhaar Fight Pits", GameAreaType.MINIGAMES, 9552),
	MG_VARROCK_RAT_PITS("Varrock Rat Pits", GameAreaType.MINIGAMES, 11599),
	MG_VOLCANIC_MINE("Volcanic Mine", GameAreaType.MINIGAMES, 15263, 15262),

	// Raids
	RAIDS_CHAMBERS_OF_XERIC("Chambers of Xeric", GameAreaType.RAIDS, 12889, 13136, 13137, 13138, 13139, 13140, 13141, 13145, 13393, 13394, 13395, 13396, 13397, 13401),
	RAIDS_THEATRE_OF_BLOOD("Theatre of Blood", GameAreaType.RAIDS, 12611, 12612, 12613, 12867, 12869, 13122, 13123, 13125, 13379),
	RAIDS_TOMBS_OF_AMASCUT("Tombs of Amascut", GameAreaType.RAIDS, 14160, 14162, 14164, 14674, 14676, 15184, 15186, 15188, 15696, 15698, 15700),
	RAIDS_JALTEVAS_PYRAMID("Jaltevas Pyramid", GameAreaType.RAIDS, 13454),
	RAIDS_OSMUMTENS_BURIAL_CHAMBER("Osmumten's Burial Chamber", GameAreaType.RAIDS, 14672),

	// Other
	REGION_ABYSSAL_AREA("Abyssal Area", GameAreaType.REGIONS, 12108),
	REGION_ABYSSAL_NEXUS("Abyssal Nexus", GameAreaType.REGIONS, 12106),
	REGION_AGILITY_PYRAMID("Agility Pyramid", GameAreaType.REGIONS, 12105, 13356),
	REGION_AIR_ALTAR("Air Altar", GameAreaType.REGIONS, 11339),
	REGION_AL_KHARID_MINE("Al Kharid Mine", GameAreaType.REGIONS, 13107),
	REGION_ANCIENT_VAULT("Ancient Vault", GameAreaType.REGIONS, 12644, 13156),
	REGION_APE_ATOLL("Ape Atoll", GameAreaType.REGIONS, 10794, 10795, 10974, 11050),
	REGION_ARANDAR("Arandar", GameAreaType.REGIONS, 9266, 9267, 9523),
	REGION_ASGARNIA("Asgarnia", GameAreaType.REGIONS, 11825, 11829, 11830, 12085, 12086),
	REGION_AVIUM_SAVANNAH("Avium Savannah", GameAreaType.REGIONS, 5935, 5936, 5937, 6189, 6445, 6446, 6447, 6701, 6702, 6703, 6957, 6958, 6959, 7215),
	REGION_BATTLEFIELD("Battlefield", GameAreaType.REGIONS, 10034),
	REGION_BATTLEFRONT("Battlefront", GameAreaType.REGIONS, 5433, 5434),
	REGION_BEEKEEPER("Beekeeper", GameAreaType.REGIONS, new RegionArea(7758, new WorldPoint(1920, 5036, 0), new WorldPoint(1934, 5051, 0))),
	REGION_BLAST_MINE("Blast Mine", GameAreaType.REGIONS, 5948),
	REGION_BODY_ALTAR("Body Altar", GameAreaType.REGIONS, 10059),
	REGION_CHAOS_ALTAR("Chaos Altar", GameAreaType.REGIONS, 9035),
	REGION_COSMIC_ALTAR("Cosmic Altar", GameAreaType.REGIONS, 8523),
	REGION_COSMIC_ENTITYS_PLANE("Cosmic Entity's Plane", GameAreaType.REGIONS, 8267),
	REGION_CRABCLAW_ISLE("Crabclaw Isle", GameAreaType.REGIONS, 6965),
	REGION_CRAFTING_GUILD("Crafting Guild", GameAreaType.REGIONS, 11571),
	REGION_CRANDOR("Crandor", GameAreaType.REGIONS, 11314, 11315),
	REGION_CRASH_ISLAND("Crash Island", GameAreaType.REGIONS, 11562),
	REGION_DARK_ALTAR("Dark Altar", GameAreaType.REGIONS, 6716),
	REGION_DEATH_ALTAR("Death Altar", GameAreaType.REGIONS, 8779),
	REGION_DEATH_PLATEAU("Death Plateau", GameAreaType.REGIONS, 11320),
	REGION_DENSE_ESSENCE("Dense Essence Mine", GameAreaType.REGIONS, 6972),
	REGION_DESERT_PLATEAU("Desert Plateau", GameAreaType.REGIONS, 13361, 13617),
	REGION_DIGSITE("Digsite", GameAreaType.REGIONS, 13365),
	REGION_DRAGONTOOTH("Dragontooth Island", GameAreaType.REGIONS, 15159),
	REGION_DRAYNOR_MANOR("Draynor Manor", GameAreaType.REGIONS, 12340),
	REGION_DRILL_SERGEANT("Drill Sergeant's Training Camp", GameAreaType.REGIONS, 12619),
	REGION_EAGLES_PEAK("Eagles' Peak", GameAreaType.REGIONS, 9270),
	REGION_EARTH_ALTAR("Earth Altar", GameAreaType.REGIONS, 10571),
	REGION_ENCHANTED_VALLEY("Enchanted Valley", GameAreaType.REGIONS, 12102),
	REGION_EVIL_TWIN("Evil Twin Crane Room", GameAreaType.REGIONS, 7504),
	REGION_EXAM_CENTRE("Exam Centre", GameAreaType.REGIONS, 13364),
	REGION_FALADOR_FARM("Falador Farm", GameAreaType.REGIONS, 12083),
	REGION_FARMING_GUILD("Farming Guild", GameAreaType.REGIONS, 4922),
	REGION_FELDIP_HILLS("Feldip Hills", GameAreaType.REGIONS, 9773, 9774, 10029, 10030, 10285, 10286, 10287, 10542, 10543),
	REGION_FENKENSTRAIN("Fenkenstrain's Castle", GameAreaType.REGIONS, 14135),
	REGION_FIGHT_ARENA("Fight Arena", GameAreaType.REGIONS, 10289),
	REGION_FIRE_ALTAR("Fire Altar", GameAreaType.REGIONS, 10315),
	REGION_FISHER_REALM("Fisher Realm", GameAreaType.REGIONS, 10569),
	REGION_FISHING_GUILD("Fishing Guild", GameAreaType.REGIONS, 10293),
	REGION_FISHING_PLATFORM("Fishing Platform", GameAreaType.REGIONS, 11059),
	REGION_FORSAKEN_TOWER("The Forsaken Tower", GameAreaType.REGIONS, 5435),
	REGION_FOSSIL_ISLAND("Fossil Island", GameAreaType.REGIONS, 14650, 14651, 14652, 14906, 14907, 14908, 15162, 15163, 15164),
	REGION_FREAKY_FORESTER("Freaky Forester's Clearing", GameAreaType.REGIONS, 10314),
	REGION_FREMENNIK("Fremennik Province", GameAreaType.REGIONS, 10296, 10552, 10808, 10809, 10810, 10811, 11064),
	REGION_FREMENNIK_ISLES("Fremennik Isles", GameAreaType.REGIONS, 9276, 9532),
	REGION_FROGLAND("Frogland", GameAreaType.REGIONS, 9802),
	REGION_GALVEK_SHIPWRECKS("Galvek Shipwrecks", GameAreaType.REGIONS, 6486, 6487, 6488, 6489, 6742, 6743, 6744, 6745),
	REGION_GHORROCK_DUNGEON("Ghorrock Dungeon", GameAreaType.REGIONS, 11681),
	REGION_GORAKS_PLANE("Gorak's Plane", GameAreaType.REGIONS, 12115),
	REGION_GRAND_EXCHANGE("Grand Exchange", GameAreaType.REGIONS, 12598),
	REGION_GRAVEDIGGER("Gravedigger", GameAreaType.REGIONS, new RegionArea(7758, new WorldPoint(1921, 4993, 0), new WorldPoint(1934, 5006, 0))),
	REGION_GWD("God Wars Dungeon", GameAreaType.REGIONS, 11578, 11346, 11347, 11602, 11603),
	REGION_HARMONY("Harmony Island", GameAreaType.REGIONS, 15148),
	REGION_HAZELMERE("Hazelmere's Island", GameAreaType.REGIONS, 10544),
	REGION_HUNTER_GUILD("Hunter Guild", GameAreaType.REGIONS, 6191),
	REGION_ICE_PATH("Ice Path", GameAreaType.REGIONS, 11322, 11323),
	REGION_ICEBERG("Iceberg", GameAreaType.REGIONS, 10558, 10559),
	REGION_ICYENE_GRAVEYARD("Icyene Graveyard", GameAreaType.REGIONS, 14641, 14897, 14898),
	REGION_ISAFDAR("Isafdar", GameAreaType.REGIONS, 8497, 8753, 8754, 9009, 9010),
	REGION_ISLAND_OF_STONE("Island of Stone", GameAreaType.REGIONS, 9790),
	REGION_ISLE_OF_SOULS("Isle of Souls", GameAreaType.REGIONS, 8236, 8237, 8238, 8491, 8492, 8494, 8747, 8750, 9003, 9004, 9006, 9260, 9261, 9262),
	REGION_JIGGIG("Jiggig", GameAreaType.REGIONS, 9775),
	REGION_KANDARIN("Kandarin", GameAreaType.REGIONS, 9268, 9269, 9014, 9263, 9264, 9519, 9524, 9527, 9776, 9783, 10037, 10290, 10294, 10546, 10551, 10805, 11062),
	REGION_KARAMJA("Karamja", GameAreaType.REGIONS,
		regionGameAreas(10801, 10802, 11054, 11311, 11312, 11313, 11566, 11567, 11568, 11569, 11822),
		new RegionArea(11825, new WorldPoint(2944, 3142, 0), new WorldPoint(2960, 3159, 0))),
	REGION_KEBOS_LOWLANDS("Kebos Lowlands", GameAreaType.REGIONS, 4665, 4666, 4667, 4921, 5178),
	REGION_KEBOS_SWAMP("Kebos Swamp", GameAreaType.REGIONS, 4664, 4920, 5174, 5175, 5176, 5430, 5431),
	REGION_KHARAZI_JUNGLE("Kharazi Jungle", GameAreaType.REGIONS, 11053, 11309, 11565, 11821),
	REGION_KHARIDIAN_DESERT("Kharidian Desert", GameAreaType.REGIONS, 12587, 12844, 12845, 12846, 12847, 12848, 13100, 13101, 13102, 13103, 13104, 13357, 13359, 13360, 13614, 13615, 13616, 13869, 13870),
	REGION_KILLERWATT_PLANE("Killerwatt Plane", GameAreaType.REGIONS, 10577),
	REGION_KOUREND("Great Kourend", GameAreaType.REGIONS, 6201, 6457, 6713),
	REGION_KOUREND_WOODLAND("Kourend Woodland", GameAreaType.REGIONS, 5942, 6197, 6453),
	REGION_LAW_ALTAR("Law Altar", GameAreaType.REGIONS, 9803),
	REGION_LEGENDS_GUILD("Legends' Guild", GameAreaType.REGIONS, 10804),
	REGION_LIGHTHOUSE("Lighthouse", GameAreaType.REGIONS, 10040),
	REGION_LITHKREN("Lithkren", GameAreaType.REGIONS, 14142, 14398),
	REGION_LUMBRIDGE_SWAMP("Lumbridge Swamp", GameAreaType.REGIONS, 12593, 12849),
	REGION_MAX_ISLAND("Max Island", GameAreaType.REGIONS, new RegionArea(11063, new WorldPoint(2786, 3535, 0), new WorldPoint(2796, 3543, 0))),
	REGION_MCGRUBORS_WOOD("McGrubor's Wood", GameAreaType.REGIONS, 10550),
	REGION_MIME_STAGE("Mime's Stage", GameAreaType.REGIONS, 8010),
	REGION_MIND_ALTAR("Mind Altar", GameAreaType.REGIONS, 11083),
	REGION_MISTHALIN("Misthalin", GameAreaType.REGIONS, 12594, 12595, 12851),
	REGION_MOLCH("Molch", GameAreaType.REGIONS, 5177),
	REGION_MOLCH_ISLAND("Molch Island", GameAreaType.REGIONS, 5432),
	REGION_MORYTANIA("Morytania", GameAreaType.REGIONS, 13619, 13620, 13621, 13622, 13876, 13877, 13879, 14133, 14134, 14389, 14390, 14391, 14645, 14647),
	REGION_MOUNT_QUIDAMORTEM("Mount Quidamortem", GameAreaType.REGIONS, 4662, 4663, 4918, 4919),
	REGION_MR_MORDAUTS_CLASSROOM("Mr. Mordaut's Classroom", GameAreaType.REGIONS, 7502),
	REGION_MUDSKIPPER("Mudskipper Point", GameAreaType.REGIONS, 11824),
	REGION_MYSTERIOUS_OLD_MAN_MAZE("Mysterious Old Man's Maze", GameAreaType.REGIONS, 11590, 11591, 11846, 11847),
	REGION_MYTHS_GUILD("Myths' Guild", GameAreaType.REGIONS, 9772),
	REGION_NATURE_ALTAR("Nature Altar", GameAreaType.REGIONS, 9547),
	REGION_NECROPOLIS("Necropolis", GameAreaType.REGIONS, 13098, 13353, 13354, 13609, 13610),
	REGION_NORTHERN_TUNDRAS("Northern Tundras", GameAreaType.REGIONS, 6204, 6205, 6717),
	REGION_OBSERVATORY("Observatory", GameAreaType.REGIONS, 9777),
	REGION_ODD_ONE_OUT("Odd One Out", GameAreaType.REGIONS, 7754),
	REGION_ORTUS_FARM("Ortus Farm", GameAreaType.REGIONS, 6192, 6193),
	REGION_OTTOS_GROTTO("Otto's Grotto", GameAreaType.REGIONS, 10038),
	REGION_OURANIA_HUNTER("Ourania Hunter Area", GameAreaType.REGIONS, 9778),
	REGION_PINBALL_RANDOM("Pinball", GameAreaType.REGIONS, new RegionArea(7758, new WorldPoint(1964, 5038, 0), new WorldPoint(1980, 5053, 0))),
	REGION_PIRATES_COVE("Pirates' Cove", GameAreaType.REGIONS, 8763),
	REGION_PISCATORIS_HUNTER_AREA("Piscatoris Hunter Area", GameAreaType.REGIONS, 9015, 9016, 9271, 9272, 9528),
	REGION_POH("Player Owned House", GameAreaType.REGIONS, 7513, 7514, 7769, 7770),
	REGION_POISON_WASTE("Poison Waste", GameAreaType.REGIONS, 8752, 9008),
	REGION_PORT_TYRAS("Port Tyras", GameAreaType.REGIONS, 8496),
	REGION_PURO_PURO("Puro Puro", GameAreaType.REGIONS, 10307),
	REGION_QUARRY("Quarry", GameAreaType.REGIONS, 12589),
	REGION_RALOS_RISE("Ralos' Rise", GameAreaType.REGIONS, 5424, 5425, 5679, 5680, 5681, 5682),
	REGION_RANGING_GUILD("Ranging Guild", GameAreaType.REGIONS, 10549),
	REGION_RATCATCHERS_MANSION("Ratcatchers Mansion", GameAreaType.REGIONS, 11343),
	REGION_RUINS_OF_ULLEK("Ruins of Ullek", GameAreaType.REGIONS, 13355, 13611, 13612),
	REGION_RUINS_OF_UNKAH("Ruins of Unkah", GameAreaType.REGIONS, 12588),
	REGION_RUNE_ESSENCE_MINE("Rune Essence Mine", GameAreaType.REGIONS, 11595),
	REGION_SCAPERUNE("ScapeRune", GameAreaType.REGIONS, 10058, 8261),
	REGION_SEA_SPIRIT_DOCK("Sea Spirit Dock", GameAreaType.REGIONS, 12332),
	REGION_SHIP_YARD("Ship Yard", GameAreaType.REGIONS, 11823),
	REGION_SILVAREA("Silvarea", GameAreaType.REGIONS, 13366),
	REGION_SINCLAR_MANSION("Sinclair Mansion", GameAreaType.REGIONS, 10807),
	REGION_SLAYER_TOWER("Slayer Tower", GameAreaType.REGIONS, 13623, 13723),
	REGION_SOUL_ALTAR("Soul Altar", GameAreaType.REGIONS, 7228),
	REGION_STRANGLEWOOD_TEMPLE("Stranglewood Temple", GameAreaType.REGIONS, 4761),
	REGION_SUNSET_COAST("Sunset Coast", GameAreaType.REGIONS, 5934, 6190),
	REGION_THE_SCAR("The Scar", GameAreaType.REGIONS, 8036, 8292),
	REGION_THE_STRANGLEWOOD("The Stranglewood", GameAreaType.REGIONS, 4403, 4404, 4659, 4660, 4661, 4916, 4917),
	REGION_TROLL_ARENA("Troll Arena", GameAreaType.REGIONS, 11576),
	REGION_TROLLHEIM("Trollheim", GameAreaType.REGIONS, 11577),
	REGION_TROLLWEISS_MTN("Trollweiss Mountain", GameAreaType.REGIONS, 11066, 11067, 11068),
	REGION_TUTORIAL_ISLAND("Tutorial Island", GameAreaType.REGIONS, 12079, 12080, 12335, 12336, 12436, 12592),
	REGION_UNDERWATER("Underwater", GameAreaType.REGIONS, 15008, 15264),
	REGION_WATER_ALTAR("Water Altar", GameAreaType.REGIONS, 10827),
	REGION_WATERBIRTH_ISLAND("Waterbirth Island", GameAreaType.REGIONS, 10042),
	REGION_WHITE_WOLF_MOUNTAIN("White Wolf Mountain", GameAreaType.REGIONS,
		new RegionArea(11062, new WorldPoint(2790, 3493, 0), new WorldPoint(2815, 3519, 0)),
		new RegionArea(11063, new WorldPoint(2795, 3520, 0), new WorldPoint(2815, 3530, 0)),
		new RegionArea(11317, new WorldPoint(2850, 3443, 0), new WorldPoint(2877, 3455, 0)),
		new RegionArea(11318, new WorldPoint(2816, 3495, 0), new WorldPoint(2879, 3519, 0)),
		new RegionArea(11318, new WorldPoint(2830, 3474, 0), new WorldPoint(2872, 3494, 0)),
		new RegionArea(11318, new WorldPoint(2834, 3462, 0), new WorldPoint(2874, 3473, 0)),
		new RegionArea(11318, new WorldPoint(2843, 3456, 0), new WorldPoint(2879, 3461, 0)),
		new RegionArea(11319, new WorldPoint(2816, 3520, 0), new WorldPoint(2873, 3529, 0))),
	REGION_WINTERTODT_CAMP("Wintertodt Camp", GameAreaType.REGIONS, 6461),
	REGION_WIZARDS_TOWER("Wizards' Tower", GameAreaType.REGIONS, 12337),
	REGION_WOODCUTTING_GUILD("Woodcutting Guild", GameAreaType.REGIONS, 6198, 6454),
	REGION_WRATH_ALTAR("Wrath Altar", GameAreaType.REGIONS, 9291),
	;

	private final String state;
	private final GameAreaType gameAreaType;
	private final List<RegionArea> regionAreas;

	GameArea(String areaName, GameAreaType areaType, int... regionIds)
	{
		this(areaName, areaType, regionGameAreas(regionIds));
	}

	GameArea(String areaName, GameAreaType areaType, RegionArea... regionAreas)
	{
		this(areaName, areaType, ImmutableList.copyOf(regionAreas));
	}

	GameArea(String areaName, GameAreaType areaType, List<RegionArea> regionAreas, RegionArea... regionArea)
	{
		final ImmutableList.Builder<RegionArea> allAreas = ImmutableList.builder();
		allAreas.addAll(regionAreas);
		allAreas.add(regionArea);

		this.state = areaName;
		this.gameAreaType = areaType;
		this.regionAreas = allAreas.build();
	}

	@Getter
	@RequiredArgsConstructor
	public static class RegionArea
	{
		private final int region;
		@Nullable
		private WorldArea area; // NOPMD: ImmutableField

		/**
		 * Create a {@code RegionArea} in a given region of the area containing the given southwest and northeast corners.
		 *
		 * @param region   Region the area is within
		 * @param swCorner Southwest corner of the area
		 * @param neCorner Northeast corner of the area
		 */
		private RegionArea(final int region, final WorldPoint swCorner, final WorldPoint neCorner)
		{
			this.region = region;
			this.area = new WorldArea(swCorner, neCorner.getX() - swCorner.getX() + 1, neCorner.getY() - swCorner.getY() + 1);
		}
	}

	private static List<RegionArea> regionGameAreas(final int... regionIds)
	{
		return Arrays.stream(regionIds)
			.mapToObj(RegionArea::new)
			.collect(Collectors.toList());
	}
}
