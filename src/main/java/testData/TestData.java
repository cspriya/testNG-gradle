package testData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageFactory.BaseObject;

/**
 * Created by N.Khmurych on 09.06.2017.
 */
public class TestData extends BaseObject {
    public final String URL                      = "https://gsmserver.com/";

    public final Integer fieldsUnLimit           = 201;

    public final String MAIN_PAGE_TITLE          = "Unlock hardware and software, spare parts for phones - GsmServer";


    public final String attrOriginalTitle        = "original-title";
    public final String attrTitle                = "title";

    @FindBy(xpath = "//div[@class='ui-lightbox-container']/descendant::a[@class='ui-lightbox-close close']")
    public WebElement closeAuthForm;

    public String[] firstNameData = new String[]{
            "Aaliyah", "Abagail", "Aaron", "Abbey", "Abbie", "Abbigail", "Abby",
            "Abdiel", "Abdul", "Abdullah", "Abe", "Abel", "Abelardo", "Abigail", "Abigale", "Abigayle", "Abner",
            "Abraham", "Ada", "Adah", "Adalberto",  "Adrianna", "Adriel", "Adrien", "Adrienne", "Afton", "Aglae",
            "Benedict", "Benjamin", "Bennett", "Bennie", "Benny", "Benton", "Berenice", "Bernadette", "Bernadine",
            "Bernard", "Bernardo", "Berneice",  "Bryce", "Brycen", "Bryon", "Buck",
            "Bud", "Buddy", "Buford", "Bulah", "Burdette", "Burley", "Burnice", "Buster", "Cade", "Caden",
            "Caesar", "Caitlyn", "Cale", "Caleb","Cordie", "Corene",
            "Corine", "Cornelius", "Cornell", "Corrine", "Cortez", "Cortney", "Cory", "Coty", "Courtney",
            "Coy", "Craig", "Crawford", "Creola", "Cristal", "Cristian", "Cristina", "Cristobal", "Cristopher",
            "Cruz", "Crystal", "Crystel", "Cullen", "Curt", "Curtis", "Cydney", "Cynthia", "Cyril", "Cyrus",
            "Dagmar", "Dahlia", "Daija", "Daisha",  "Donna", "Donnell", "Donnie", "Donny", "Dora",
            "Dorcas", "Dorian", "Doris", "Dorothea", "Dorothy", "Dorris", "Dortha", "Dorthy", "Doug", "Douglas",
            "Dovie", "Doyle", "Drake", "Drew", "Duane", "Dudley", "Dulce", "Duncan", "Durward", "Dustin",
            "Dusty", "Dwight", "Dylan", "Earl", "Ernestine", "Ernesto", "Ernie", "Ervin", "Erwin", "Eryn", "Esmeralda",
            "Esperanza", "Esta", "Esteban", "Estefania", "Estel", "Florence", "Florencio", "Florian", "Florida",
            "Florine", "Flossie", "Floy", "Floyd", "Ford", "Forest", "Forrest", "Foster", "Frances", "Francesca",
            "Francesco", "Francis", "Francisca", "Francisco", "Franco", "Frank", "Frankie", "Franz", "Fred", "Freda",
            "Freddie", "Freddy", "Frederic", "Frederick", "Gregory", "Greta", "Gretchen", "Greyson", "Griffin",
            "Guiseppe", "Gunnar", "Gunner", "Gus", "Gussie", "Gust", "Gustave", "Guy", "Gwen", "Gwendolyn", "Hadley",
            "Hailee", "Hailey", "Hailie", "Hal", "Haleigh", "Haley","Hortense", "Hosea", "Houston", "Howard",
            "Howell", "Hoyt", "Hubert", "Hudson", "Hugh", "Hulda", "Humberto", "Hunter", "Hyman", "Ian", "Ibrahim",
            "Icie", "Ida", "Idell", "Idella", "Ignacio", "Ignatius", "Ivory", "Ivy", "Izabella", "Izaiah",
            "Jabari", "Jace", "Jacey", "Jacinthe", "Jacinto", "Jack",  "Johanna", "Johathan", "John",
            "Johnathan", "Johnathon", "Johnnie", "Johnny", "Johnpaul", "Johnson", "Jolie", "Jon", "Jonas", "Jonatan",
            "Jonathan", "Jonathon", "Jordan", "Jordane", "Jordi", "Jordon", "Jordy", "Jordyn", "Jorge", "Jose",
            "Josefa", "Josefina", "Joseph", "Josephine", "Josh", "Junior", "Junius", "Justen", "Justice", "Justina",
            "Justine", "Juston", "Justus", "Justyn", "Juvenal", "Juwan", "Kacey", "Kaci", "Kacie", "Kade", "Kaden",
            "Kadin", "Kaela", "Kaelyn", "Kaia", "Kailee", "Kailey", "Kailyn", "Kaitlin", "Kaitlyn", "Kale", "Kaleb",
            "Kaleigh", "Kaley", "Kali", "Kallie", "Kameron",  "Kristina", "Kristofer", "Kristoffer", "Kristopher",
            "Kristy", "Krystal", "Krystel", "Krystina", "Kurt", "Kurtis", "Kyla", "Kyle", "Kylee", "Kyleigh", "Kyler",
            "Kylie", "Kyra", "Lacey", "Lacy", "Ladarius", "Lafayette", "Laila", "Laisha", "Lamar", "Lambert",
            "Lamont", "Lance", "Landen", "Lane", "Laney", "Lydia", "Lyla", "Lynn", "Lyric", "Lysanne", "Mabel",
            "Mabelle", "Mable", "Mac", "Macey", "Maci",  "Myrna", "Myron", "Myrtice", "Myrtie", "Myrtis", "Myrtle",
            "Nadia", "Nakia", "Name", "Nannie", "Naomi", "Nyasia", "Obie", "Oceane", "Ocie", "Octavia", "Oda",
            "Odell", "Odessa", "Odie", "Ofelia", "Okey", "Ola", "Olaf", "Ole", "Olen", "Oleta", "Olga", "Olin",
            "Oliver", "Ollie", "Oma", "Omari", "Omer", "Oswald", "Oswaldo", "Otha", "Otho", "Otilia", "Otis", "Ottilie",
            "Ottis", "Otto", "Ova", "Owen", "Ozella", "Petra", "Peyton", "Philip", "Phoebe", "Phyllis", "Pierce",
            "Pierre", "Pietro", "Pink", "Pinkie", "Piper", "Polly", "Porter", "Precious", "Presley", "Preston",
            "Price", "Prince", "Princess", "Priscilla", "Russel", "Russell", "Rusty", "Ruth", "Ruthe", "Ruthie", "Ryan",
            "Ryann", "Ryder", "Rylan", "Rylee", "Ryleigh", "Ryley", "Sabina", "Sabrina", "Sabryna", "Sadie", "Sadye",
            "Sage", "Saige", "Sallie", "Sally", "Salma", "Sylvia", "Tabitha", "Tad", "Talia", "Talon", "Tamara",
            "Tania", "Tanner", "Tanya", "Tara", "Taryn",  "Tyshawn", "Tyson", "Ubaldo", "Ulices", "Ulises", "Una",
            "Urban", "Uriah", "Uriel", "Ursula", "Vada",  "Viviane", "Vivianne", "Vivien", "Vivienne", "Vladimir",
            "Wade", "Waino", "Waldo", "Walker", "Wallace", "Winifred", "Winnifred", "Winona", "Winston", "Woodrow",
            "Wyatt", "Wyman", "Xander", "Xavier", "Xzavier", "Yadira", "Yasmeen", "Yasmin", "Yasmine", "Yazmin",
            "Yesenia", "Yessenia", "Yolanda", "Yoshiko", "Yvette", "Yvonne", "Zachariah", "Zachary", "Zachery",
            "Zack", "Zackary", "Zackery", "Zakary", "Zander","Zoey", "Zoie", "Zoila", "Zola", "Zora", "Zula"
    };

    public String[] lastNameData = new String[]{
            "Abbott", "Abernathy", "Abshire", "Beatty", "Bechtelar", "Becker", "Bednar", "Beer", "Beier", "Berge",
            "Bergnaum", "Bergstrom", "Bernhard", "Bernier", "Bins", "Blanda", "Blick", "Block", "Bode", "Boehm",
            "Bogisich", "Borer", "Bosco", "Botsford", "Boyer", "Boyle", "Bradtke", "Brakus", "Braun", "Breitenberg",
            "Brekke", "Brown", "Bruen", "Buckridge", "Carroll", "Carter", "Cartwright", "Casper", "Cassin", "Champlin",
            "Christiansen", "Cole", "Collier", "Collins", "Conn", "Connelly", "Conroy", "Considine", "Corkery",
            "Corwin", "Cremin", "Crist", "Crona", "Cronin", "Crooks", "Cruickshank", "Cummerata", "Cummings", "Dach",
            "D'Amore", "Daniel", "Dare", "Daugherty", "Davis", "Deckow", "Denesik", "Dibbert", "Dickens", "Dicki",
            "Dickinson", "Dietrich", "Donnelly", "Dooley", "Douglas", "Doyle", "DuBuque", "Durgan", "Ebert", "Effertz",
            "Eichmann", "Emard", "Emmerich", "Erdman", "Ernser", "Fadel", "Fahey", "Farrell", "Fay", "Feeney", "Feest",
            "Feil", "Ferry", "Fisher", "Flatley", "Frami", "Franecki", "Friesen", "Fritsch", "Funk", "Gaylord",
            "Gerlach", "Gibson", "Gislason", "Gleason", "Gleichner", "Glover", "Goldner", "Goodwin", "Gorczany",
            "Goyette", "Grady", "Graham", "Grant", "Green", "Greenfelder", "Greenholt", "Grimes", "Gulgowski",
            "Gutkowski", "Gutmann",  "Hansen", "Harber", "Harris", "Hartmann", "Harvey", "Hauck", "Hayes", "Heaney",
            "Hegmann", "Heidenreich", "Heller", "Herman", "Hermann", "Hermiston", "Herzog", "Hessel", "Hettinger",
            "Hickle", "Hilll", "Hills", "Hilpert", "Hintz", "Hirthe", "Hodkiewicz", "Hoeger", "Homenick", "Hoppe",
            "Howe", "Howell", "Hudson", "Huel", "Huels", "Hyatt", "Jacobi", "Jacobs", "Jacobson", "Jakubowski",
            "Jaskolski", "Jast", "Jenkins", "Jerde", "Johns", "Johnson", "Johnston", "Jones", "Kassulke", "Kautzer",
            "Kuphal", "Kutch", "Kuvalis", "Labadie", "Lakin", "Lang", "Langosh", "Macejkovic", "MacGyver", "Maggio",
            "Purdy", "Quigley", "Quitzon", "Rath", "Ratke", "Rau", "Raynor", "Reichel", "Reichert", "Reilly",
            "Reinger", "Rowe", "Ruecker", "Runolfsdottir", "Runolfsson", "Runte", "Russel", "Rutherford", "Ryan",
            "Sanford", "Satterfield", "Sauer", "Sawayn", "Schaden", "Schaefer", "Schamberger", "Schiller", "Schimmel",
            "Weber", "Wehner", "Weimann", "Ziemann", "Zieme", "Zulauf",
    };

    public String[] citiesData = new String[] {
            "Gerastetten", "Neunbirge", "Beverport", "Naamzen", "Carcassis", "Nanllac",
            "Obernthal", "Herlingen", "Skibbeshannon", "Trasale", "Hoogeberg", "Leeuwburg", "Vernacht", "Surtal",
            "Innssee", "Harttetten", "Vilmel", "Aarsen", "Courves", "Aurinnois", "Dornsten", "Adewagen", "Monalow",
            "Clonbet", "Emmond", "Vlissingsingen", "Menmundigen", "Crogswil", "Hallbühel", "Mödten", "Vilven",
            "Oudeneinde", "Soigues", "Antossy", "Großdorf", "Allenhöring", "Drogkilty", "Midlelick", "Arnelen",
            "Vollenveen", "Frauensee", "Verdrisio", "Trinichito", "Mafrekins", "Sabaye", "Llota", "Candetepan",
            "Soncuba", "Santa Carnahu", "San Beibal", "San Marrada", "Yorinuare", "Waguaque", "Bocagua", "La Megui",
            "Capeltos", "Lemowee", "San Joaya", "Sardia", "Sipiles", "Armestin", "Jucuares", "Catoria", "Guastajachel",
            "Lepasica", "Graquito", "Pueya", "Jinotapa", "La Hegana", "Arraigui"
    };

    public String[] streetsData = new String[] {
            "Sun Row", "Beaver Route", "Castle Street", "Onyx Avenue", "Baker Lane", "Circus Avenue", "Clarity Passage",
            "Azure Avenue", "Pearl Avenue", "Old Boulevard", "Jade Passage", "Cavern Boulevard", "Queen Avenue",
            "Plaza Boulevard", "Gem Street", "Silver Street", "Barley Boulevard", "Dove Way", "Amber Street",
            "Kingwood Boulevard", "Justice Lane", "Park Passage", "Pine Way", "Penrose Lane", "Central Row",
            "Redwood Lane", "West Route", "Vermilion Route", "Chestnut Street", "Cannon Row", "Dew Lane", "Jade Way",
            "General Row", "Bell Lane", "Rowan Avenue", "Bellow Street", "Chapel Avenue", "Farmer Way", "Mount Passage",
            "Ash Avenue", "Lumber Street", "Angel Lane", "Moonlight Avenue", "Cedar Passage", "Hart Route",
            "Bloomfield Lane", "Lily Passage", "Dove Avenue", "Bellow Route", "Pegasus Lane", "Peace Street",
            "Copper Street", "Frost Passage", "Heritage Passage", "Innovation Boulevard", "National Route",
            "Maple Passage", "Colonel Avenue", "Onyx Street", "Estate Avenue"
    };

    public TestData(WebDriver driver) {
        super(driver);
    }
}
