package olympic.main.person;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * 为运动员随机生成姓名
 */
public class NameFactory {
    static  String[] lastNameEn={
            " Wu",
            " Yang",
            " Zhang",
            " Luo",
            " Admirind",
            " Aerum",
            " Akvum",
            " Ambrofaltkhawsen",
            " Ameblo",
            " Amik",
            " Amomian",
            " Arbar",
            " Barbarkor",
            " Bier",
            " Bird",
            " Biterlif",
            " Bondno",
            " Bravul",
            " Burlu",
            " Butik",
            " Celum",
            " Chener",
            " Chipen",
            " Delolmo",
            " Devum",
            " Domet",
            " Ehhum",
            " Emilan",
            " Enhhoran",
            " Esper",
            " Estrum",
            " Fajrer",
            " Famili",
            " Fesanan",
            " Filopator",
            " Fiskan",
            " Flugil",
            " Garan",
            " Geralan",
            " Gimik",
            " Glaving",
            " Grinhilt",
            " Gust",
            " Gharden",
            " Hakil",
            " Hark",
            " Haska",
            " Heldan",
            " Herb",
            " Homar",
            " Horbek",
            " Hhorum",
            " Inkuj",
            " Interes",
            " Irlan",
            " Ivens",
            " Jablich",
            " Jagu",
            " Jarum",
            " Junul",
            " Jhurnal",
            " Kamino",
            " Kandeling",
            " Kanjas",
            " Karlan",
            " Klub",
            " Kodlar",
            " Korjas",
            " Kovert",
            " Kradan",
            " Kredeblo",
            " Kruf",
            " Kudril",
            " Kuirej",
            " Kunul",
            " Kuvan",
            " Kvarop",
            " Laget",
            " Lamris",
            " Land",
            " Libret",
            " Loghej",
            " Lumstel",
            " Makavel",
            " Maksipes",
            " Marban",
            " Marist",
            " Marsaus",
            " Marum",
            " Mehhkaprad",
            " Memorind",
            " Montum",
            " Montril",
            " Nakan",
            " Nomum",
            " Oktoped",
            " Ostum",
            " Paner",
            " Panum",
            " Pentium",
            " Pentrist",
            " Pepian",
            " Pilk",
            " Piruj",
            " Pluming",
            " Plumuj",
            " Pluver",
            " Pomuj",
            " Preghej",
            " Pulver",
            " Rafnil",
            " Ralfan",
            " Rastagan",
            " Razil",
            " Regnestrum",
            " Regum",
            " Richul",
            " Rukspin",
            " Sabler",
            " Saghulo",
            " Sagum",
            " Saist",
            " Skatol",
            " Stelum",};

        static String[] namesEn = {
                "Chenhao",
                "Junjie",
                "Yuqing",
                "Yang",
                "Manxin",
                "Baiyi",
                "Aaron",
                "Abel",
                "Abraham",
                "Adam",
                "Adrian",
                "Aidan",
                "Alva",
                "Alex",
                "Alexander",
                "Alan",
                "Albert",
                "Alfred",
                "Andrew",
                "Andy",
                "Angus",
                "Anthony",
                "Apollo",
                "Arnold",
                "Arthur",
                "August",
                "Austin",
                "Ben",
                "Benjamin",
                "Bert",
                "Benson",
                "Bill",
                "Billy",
                "Blake",
                "Bob",
                "Bobby",
                "Brad",
                "Brandon",
                "Brant",
                "Brent",
                "Brian",
                "Brown",
                "Bruce",
                "Caleb",
                "Cameron",
                "Carl",
                "Carlos",
                "Cary",
                "Caspar",
                "Cecil",
                "Charles",
                "Cheney",
                "Chris",
                "Christian",
                "Christopher",
                "Clark",
                "Cliff",
                "Cody",
                "Cole",
                "Colin",
                "Cosmo",
                "Daniel",
                "Denny",
                "Darwin",
                "David",
                "Dennis",
                "Derek",
                "Dick",
                "Donald",
                "Douglas",
                "Duke",
                "Dylan",
                "Eddie",
                "Edgar",
                "Edison",
                "Edmund",
                "Edward",
                "Edwin",
                "Elijah",
                "Elliott",
                "Elvis",
                "Eric",
                "Ethan",
                "Eugene",
                "Evan",
                "Enterprise",
                "Ford",
                "Francis",
                "Frank",
                "Franklin",
                "Fred",
                "Gabriel",
                "Gaby",
                "Garfield",
                "Gary",
                "Gavin",
                "Geoffrey",
                "George",
                "Gino",
                "Glen",
                "Glendon",
                "Hank",
                "Hardy",
                "Harrison",
                "Harry",
                "Hayden",
                "Henry",
                "Hilton",
                "Hugo",
                "Hunk",
                "Howard",
                "Henry",
                "Ian",
                "Ignativs",
                "Ivan",
                "Isaac",
                "Isaiah",
                "Jack",
                "Jackson",
                "Jacob",
                "James",
                "Jason",
                "Jay",
                "Jeffery",
                "Jerome",
                "Jerry",
                "Jesse",
                "Jim",
                "Jimmy",
                "Joe",
                "John",
                "Johnny",
                "Jonathan",
                "Jordan",
                "Jose",
                "Joshua",
                "Justin",
                "Keith",
                "Ken",
                "Kennedy",
                "Kenneth",
                "Kenny",
                "Kevin",
                "Kyle",
                "Lance",
                "Larry",
                "Laurent",
                "Lawrence",
                "Leander",
                "Lee",
                "Leo",
                "Leonard",
                "Leopold",
                "Leslie",
                "Loren",
                "Lori",
                "Lorin",
                "Louis",
                "Luke",
                "Marcus",
                "Marcy",
                "Mark",
                "Marks",
                "Mars",
                "Marshal",
                "Martin",
                "Marvin",
                "Mason",
                "Matthew",
                "Max",
                "Michael",
                "Mickey",
                "Mike",
                "Nathan",
                "Nathaniel",
                "Neil",
                "Nelson",
                "Nicholas",
                "Nick",
                "Noah",
                "Norman",
                "Oliver",
                "Oscar",
                "Owen",
                "Patrick",
                "Paul",
                "Peter",
                "Philip",
                "Phoebe",
                "Quentin",
                "Randall",
                "Randolph",
                "Randy",
                "Ray",
                "Raymond",
                "Reed",
                "Rex",
                "Richard",
                "Richie",
                "Riley",
                "Robert",
                "Robin",
                "Robinson",
                "Rock",
                "Roger",
                "Ronald",
                "Rowan",
                "Roy",
                "Ryan",
                "Sam",
                "Sammy",
                "Samuel",
                "Scott",
                "Sean",
                "Shawn",
                "Sidney",
                "Simon",
                "Solomon",
                "Spark",
                "Spencer",
                "Spike",
                "Stanley",
                "Steve",
                "Steven",
                "Stewart",
                "Stuart",
                "Terence",
                "Terry",
                "Ted",
                "Thomas",
                "Tim",
                "Timothy",
                "Todd",
                "Tommy",
                "Tom",
                "Thomas",
                "Tony",
                "Tyler",
                "Ultraman",
                "Ulysses",
                "Van",
                "Vern",
                "Vernon",
                "Victor",
                "Vincent",
                "Warner",
                "Warren",
                "Wayne",
                "Wesley",
                "William",
                "Willy",
                "Zack",
                "Zachary",
                "Abigail",
                "Abby",
                "Ada",
                "Adelaide",
                "Adeline",
                "Alexandra",
                "Ailsa",
                "Aimee",
                "Alexis",
                "Alice",
                "Alicia",
                "Alina",
                "Allison",
                "Alyssa",
                "Amanda",
                "Amy",
                "Amber",
                "Anastasia",
                "Andrea",
                "Angel",
                "Angela",
                "Angelia",
                "Angelina",
                "Ann",
                "Anna",
                "Anne",
                "Annie",
                "Anita",
                "Ariel",
                "April",
                "Ashley",
                "Audrey",
                "Aviva",
                "Barbara",
                "Barbie",
                "Beata",
                "Beatrice",
                "Becky",
                "Bella",
                "Bess",
                "Bette",
                "Betty",
                "Blanche",
                "Bonnie",
                "Brenda",
                "Brianna",
                "Britney",
                "Brittany",
                "Camille",
                "Candice",
                "Candy",
                "Carina",
                "Carmen",
                "Carol",
                "Caroline",
                "Carry",
                "Carrie",
                "Cassandra",
                "Cassie",
                "Catherine",
                "Cathy",
                "Chelsea",
                "Charlene",
                "Charlotte",
                "Cherry",
                "Cheryl",
                "Chloe",
                "Chris",
                "Christina",
                "Christine",
                "Christy",
                "Cindy",
                "Claire",
                "Claudia",
                "Clement",
                "Cloris",
                "Connie",
                "Constance",
                "Cora",
                "Corrine",
                "Crystal",
                "Daisy",
                "Daphne",
                "Darcy",
                "Dave",
                "Debbie",
                "Deborah",
                "Debra",
                "Demi",
                "Diana",
                "Dolores",
                "Donna",
                "Dora",
                "Doris",
                "Edith",
                "Editha",
                "Elaine",
                "Eleanor",
                "Elizabeth",
                "Ella",
                "Ellen",
                "Ellie",
                "Emerald",
                "Emily",
                "Emma",
                "Enid",
                "Elsa",
                "Erica",
                "Estelle",
                "Esther",
                "Eudora",
                "Eva",
                "Eve",
                "Evelyn",
                "Fannie",
                "Fay",
                "Fiona",
                "Flora",
                "Florence",
                "Frances",
                "Frederica",
                "Frieda",
                "Flta",
                "Gina",
                "Gillian",
                "Gladys",
                "Gloria",
                "Grace",
                "Grace",
                "Greta",
                "Gwendolyn",
                "Hannah",
                "Haley",
                "Hebe",
                "Helena",
                "Hellen",
                "Henna",
                "Heidi",
                "Hillary",
                "Ingrid",
                "Isabella",
                "Ishara",
                "Irene",
                "Iris",
                "Ivy",
                "Jacqueline",
                "Jade",
                "Jamie",
                "Jane",
                "Janet",
                "Jasmine",
                "Jean",
                "Jenna",
                "Jennifer",
                "Jenny",
                "Jessica",
                "Jessie",
                "Jill",
                "Joan",
                "Joanna",
                "Jocelyn",
                "Joliet",
                "Josephine",
                "Josie",
                "Joy",
                "Joyce",
                "Judith",
                "Judy",
                "Julia",
                "Juliana",
                "Julie",
                "June",
                "Karen",
                "Karida",
                "Katherine",
                "Kate",
                "Kathy",
                "Katie",
                "Katrina",
                "Kay",
                "Kayla",
                "Kelly",
                "Kelsey",
                "Kimberly",
                "Kitty",
                "Lareina",
                "Lassie",
                "Laura",
                "Lauren",
                "Lena",
                "Lydia",
                "Lillian",
                "Lily",
                "Linda",
                "lindsay",
                "Lisa",
                "Liz",
                "Lora",
                "Lorraine",
                "Louisa",
                "Louise",
                "Lucia",
                "Lucy",
                "Lucine",
                "Lulu",
                "Lydia",
                "Lynn",
                "Mabel",
                "Madeline",
                "Maggie",
                "Mamie",
                "Manda",
                "Mandy",
                "Margaret",
                "Mariah",
                "Marilyn",
                "Martha",
                "Mavis",
                "Mary",
                "Matilda",
                "Maureen",
                "Mavis",
                "Maxine",
                "May",
                "Mayme",
                "Megan",
                "Melinda",
                "Melissa",
                "Melody",
                "Mercedes",
                "Meredith",
                "Mia",
                "Michelle",
                "Milly",
                "Miranda",
                "Miriam",
                "Miya",
                "Molly",
                "Monica",
                "Morgan",
                "Nancy",
                "Natalie",
                "Natasha",
                "Nicole",
                "Nikita",
                "Nina",
                "Nora",
                "Norma",
                "Nydia",
                "Octavia",
                "Olina",
                "Olivia",
                "Ophelia",
                "Oprah",
                "Pamela",
                "Patricia",
                "Patty",
                "Paula",
                "Pauline",
                "Pearl",
                "Peggy",
                "Philomena",
                "Phoebe",
                "Phyllis",
                "Polly",
                "Priscilla",
                "Quentina",
                "Rachel",
                "Rebecca",
                "Regina",
                "Rita",
                "Rose",
                "Roxanne",
                "Ruth",
                "Sabrina",
                "Sally",
                "Sandra",
                "Samantha",
                "Sami",
                "Sandra",
                "Sandy",
                "Sarah",
                "Savannah",
                "Scarlett",
                "Selma",
                "Selina",
                "Serena",
                "Sharon",
                "Sheila",
                "Shelley",
                "Sherry",
                "Shirley",
                "Sierra",
                "Silvia",
                "Sonia",
                "Sophia",
                "Stacy",
                "Stella",
                "Stephanie",
                "Sue",
                "Sunny",
                "Susan",
                "Tamara",
                "Tammy",
                "Tanya",
                "Tasha",
                "Teresa",
                "Tess",
                "Tiffany",
                "Tina",
                "Tonya",
                "Tracy",
                "Ursula",
                "Vanessa",
                "Venus",
                "Vera",
                "Vicky",
                "Victoria",
                "Violet",
                "Virginia",
                "Vita",
                "Vivian"
        };
    /**
     * 国家枚举
     */
    static String[] nation={
            "CHN","MGL","PRK","KOR","JPN","PHI","VIE","LAO","MYA","THA","MAL","SGP","IHO",
           "NEP","IND","PAK","SRI",
            "KAZ","TJK","UZB","IRQ","JOR","LBN","ISR","PLE","KSA",
            "EST","BLR","RUS","POL","CZE","SVK","HUN","GER","AUT","SUI","GBR","IRL",
            "NED","BEL","LUX","FRA","MLT","ESP","POR","USA","AUS","NZL"
};
    static String[] firstNameInside = {
            "赵" , "钱" , "孙" , "李" , "周" , "吴" , "郑" , "王",
            "冯" , "陈" , "楮" , "卫" , "蒋" , "沈" , "韩" , "杨",
            "朱" , "秦" , "尤" , "许" , "何" , "吕" , "施" , "张",
            "孔" , "曹" , "严" , "华" , "金" , "魏" , "陶" , "姜",
            "戚" , "谢" , "邹" , "喻" , "柏" , "水" , "窦" , "章",
            "云" , "苏" , "潘" , "葛" , "奚" , "范" , "彭" , "郎",
            "鲁" , "韦" , "昌" , "马" , "苗" , "凤" , "花" , "方",
            "俞" , "任" , "袁" , "柳" , "酆" , "鲍" , "史" , "唐",
            "费" , "廉" , "岑" , "薛" , "雷" , "贺" , "倪" , "汤",
            "滕" , "殷" , "罗" , "毕" , "郝" , "邬" , "安" , "常",
            "乐" , "于" , "时" , "傅" , "皮" , "卞" , "齐" , "康",
            "伍" , "余" , "元" , "卜" , "顾" , "孟" , "平" , "黄",
            "和" , "穆" , "萧" , "尹" , "姚" , "邵" , "湛" , "汪",
            "祁" , "毛" , "禹" , "狄" , "米" , "贝" , "明" , "臧",
            "计" , "伏" , "成" , "戴" , "谈" , "宋" , "茅" , "庞",
            "熊" , "纪" , "舒" , "屈" , "项" , "祝" , "董" , "梁",
            "杜" , "阮" , "蓝" , "闽" , "席" , "季" , "麻" , "强",
            "贾" , "路" , "娄" , "危" , "江" , "童" , "颜" , "郭",
            "梅" , "盛" , "林" , "刁" , "锺" , "徐" , "丘" , "骆",
            "高" , "夏" , "蔡" , "田" , "樊" , "胡" , "凌" , "霍",
            "虞" , "万" , "支" , "柯" , "昝" , "管" , "卢" , "莫",
            "经" , "房" , "裘" , "缪" , "干" , "解" , "应" , "宗",
            "丁" , "宣" , "贲" , "邓" , "郁" , "单" , "杭" , "洪",
            "包" , "诸" , "左" , "石" , "崔" , "吉" , "钮" , "龚",
            "程" , "嵇" , "邢" , "滑" , "裴" , "陆" , "荣" , "翁",
            "荀" , "羊" , "於" , "惠" , "甄" , "麹" , "家" , "封",
            "芮" , "羿" , "储" , "靳" , "汲" , "邴" , "糜" , "松",
            "井" , "段" , "富" , "巫" , "乌" , "焦" , "巴" , "弓",
            "牧" , "隗" , "山" , "谷" , "车" , "侯" , "宓" , "蓬",
            "全" , "郗" , "班" , "仰" , "秋" , "仲" , "伊" , "宫",
            "宁" , "仇" , "栾" , "暴" , "甘" , "斜" , "厉" , "戎",
            "祖" , "武" , "符" , "刘" , "景" , "詹" , "束" , "龙",
            "叶" , "幸" , "司" , "韶" , "郜" , "黎" , "蓟" , "薄",
            "印" , "宿" , "白" , "怀" , "蒲" , "邰" , "从" , "鄂",
            "索" , "咸" , "籍" , "赖" , "卓" , "蔺" , "屠" , "蒙",
            "池" , "乔" , "阴" , "郁" , "胥" , "能" , "苍" , "双",
            "闻" , "莘" , "党" , "翟" , "谭" , "贡" , "劳" , "逄",
            "姬" , "申" , "扶" , "堵" , "冉" , "宰" , "郦" , "雍",
            "郤" , "璩" , "桑" , "桂" , "濮" , "牛" , "寿" , "通",
            "边" , "扈" , "燕" , "冀" , "郏" , "浦" , "尚" , "农",
            "温" , "别" , "庄" , "晏" , "柴" , "瞿" , "阎" , "充",
            "慕" , "连" , "茹" , "习" , "宦" , "艾" , "鱼" , "容",
            "向" , "古" , "易" , "慎" , "戈" , "廖" , "庾" , "终",
            "暨" , "居" , "衡" , "步" , "都" , "耿" , "满" , "弘",
            "匡" , "国" , "文" , "寇" , "广" , "禄" , "阙" , "东",
            "欧" , "殳" , "沃" , "利" , "蔚" , "越" , "夔" , "隆",
            "师" , "巩" , "厍" , "聂" , "晁" , "勾" , "敖" , "融",
            "冷" , "訾" , "辛" , "阚" , "那" , "简" , "饶" , "空",
            "曾" , "毋" , "沙" , "乜" , "养" , "鞠" , "须" , "丰",
            "巢" , "关" , "蒯" , "相" , "查" , "后" , "荆" , "红",
            "游" , "竺" , "权" , "逑" , "盖" , "益" , "桓" , "公",
            "万俟" , "司马" , "上官" , "欧阳",
            "夏侯" , "诸葛" , "闻人" , "东方",
            "赫连" , "皇甫" , "尉迟" , "公羊",
            "澹台" , "公冶" , "宗政" , "濮阳",
            "淳于" , "单于" , "太叔" , "申屠",
            "公孙" , "仲孙" , "轩辕" , "令狐",
            "锺离" , "宇文" , "长孙" , "慕容",
            "鲜于" , "闾丘" , "司徒" , "司空",
            "端木" , "巫马" , "公西",
            "漆雕" , "乐正" ,  "公良",
            "拓拔" , "夹谷" , "宰父" , "谷梁",
            "晋" , "楚" , "阎" , "法" , "汝" ,  "涂" , "钦",
            "段干" , "百里" , "东郭" , "南门",
            "呼延" , "归" , "海" , "羊舌" , "微生",
            "岳" , "帅" , "缑" , "亢" , "况" , "后" , "有" , "琴",
            "梁丘" , "左丘" , "东门" , "西门",
            "商" , "牟" , "佘" , "佴" , "伯" , "赏" , "南宫",
            "墨" ,  "年" , "爱" , "阳" , "佟",
            "第五" , "言" , "福"
    };
    /**
     * 名字set
     */
    private HashSet<String> sites = new HashSet<String>();
    /**
     * 国家队set
     */
    private HashSet<String> nationSites = new HashSet<String>();

    /**
     * random种子
     */
    private Random random=new Random();

    /**
     * 使用数组的方式存储姓氏
     * @return 数组中随机下标的字符串
     */
    private String insideFirstName() {
        int i = random.nextInt(firstNameInside.length);//[0,n)
        return firstNameInside[i];
    }

    /**
     * 去掉了相当多的繁体字
     * @return 随机生成一个汉字
     */
    private String insideSimpleLastName(){
        String[] black= {"阳婉","俊吉","空心","千一","紫玉","利兴","程颢","玉清","英文","橙味"};
        int blackNum=random.nextInt(13);
        if(blackNum==0){
            return black[random.nextInt(10)];

        }

        int hight,low;//二进制的高低位
        Random random= new Random();
        StringBuilder sBuilder = new StringBuilder();

        int lastLenght = 1+random.nextInt(2);

        for(int i=0;i<lastLenght;i++) {
            hight = 176+random.nextInt(39);
            low = 161+random.nextInt(93);
            byte[]han = new byte[2];
            han[0]= Integer.valueOf(hight).byteValue();
            han[1]= Integer.valueOf(low).byteValue();
            try {
                sBuilder.append(new String(han,"gbk"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sBuilder.toString();
    }

    /**
     * 返回一个不会重复的英语名字
     * @return 英文名
     */
    private String getEnglishName() {
        int i = random.nextInt(namesEn.length);//[0,n)
        int j=random.nextInt(lastNameEn.length);
        while(sites.contains(namesEn[i]+lastNameEn[j])){
            i = random.nextInt(namesEn.length);
            j=random.nextInt(lastNameEn.length);
        }
        sites.add(namesEn[i]+lastNameEn[j]);
        return namesEn[i]+lastNameEn[j];
    }

    /**
     * 返回一个不会重复的中文名字
     */
    private String getChineseName() {
         String name= insideFirstName()+insideSimpleLastName();
        while(sites.contains(name)){
            name= insideFirstName()+insideSimpleLastName();
        }
        sites.add(name);
        return name;
    }

    /**
     * 随机返回国家、姓名
     * @return 全名
     */
    public Message getMessage() {
        Message message=new Message();
        int i = random.nextInt(nation.length);//[0,n)
        message.nation=nation[i];
        if(i<=5){
            message.name=getChineseName();

        }
        else{
            message.name=getEnglishName();
        }
        return message;
    }
    /**
     * 取得一个队的运动员信息
     *
     * @param n 队中运动员数量
     * @return 运动员信息列表
     */
    public List<Message> getMessageList(int n) {
        List<Message> messages=new ArrayList<>();
        int i = random.nextInt(nation.length);//[0,n)
        int num = 1;
        // 国家几队
        while (nationSites.contains(nation[i] + num + "队")) {
            num++;
        }
        nationSites.add(nation[i] + num + "队");
        //为该国家队添加队员
        for (int j = 0; j < n; j++) {
            if (i <= 5) {
                messages.add(new Message(getChineseName(), nation[i]));
            } else {
                messages.add(new Message(getEnglishName(), nation[i]));
            }
        }
        messages.add(new Message(nation[i]+num+"队",nation[i]));
        return messages;
    }

}



//    private String getName() {
//        Random random = new Random();
//        String[] Surname = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许",
//                "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎",
//                "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳", "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷",
//                "罗", "毕", "郝", "邬", "安", "常", "乐", "于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和",
//                "穆", "萧", "尹", "姚", "邵", "湛", "汪", "祁", "毛", "禹", "狄", "米", "贝", "明", "臧", "计", "伏", "成", "戴", "谈", "宋", "茅", "庞", "熊", "纪", "舒",
//                "屈", "项", "祝", "董", "梁", "杜", "阮", "蓝", "闵", "席", "季"};
//        String girl = "秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";
//        String boy = "伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";
//        int index = random.nextInt(Surname.length - 1);
//        String name = Surname[index]; //获得一个随机的姓氏
//        int i = random.nextInt(3);//可以根据这个数设置产生的男女比例
//        if(i==2){
//            int j = random.nextInt(girl.length()-2);
//            if (j % 2 == 0) {
//                name = "女-" + name + girl.substring(j, j + 2);
//            } else {
//                name = "女-" + name + girl.substring(j, j + 1);
//            }
//
//        }
//        else{
//            int j = random.nextInt(girl.length()-2);
//            if (j % 2 == 0) {
//                name = "男-" + name + boy.substring(j, j + 2);
//            } else {
//                name = "男-" + name + boy.substring(j, j + 1);
//            }
//
//        }
//
//        return name;
//    }














