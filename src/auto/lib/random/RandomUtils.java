package auto.lib.random;

import auto.lib.date.DateUtils;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Random;


public class RandomUtils {

	static String[] cityNameList = {
			"北京市","广东省","山东省","江苏省","河南省","上海市","河北省","浙江省","香港特别行政区","陕西省","湖南省","重庆市","福建省","天津市","云南省","四川省","广西壮族自治区","安徽省","海南省","江西省","湖北省","山西省","辽宁省","台湾省","黑龙江","内蒙古自治区","澳门特别行政区","贵州省","甘肃省","青海省","新疆维吾尔自治区","西藏区","吉林省","宁夏回族自治区","东莞市","广州市","中山市","深圳市","惠州市","江门市","珠海市","汕头市","佛山市","湛江市","河源市","肇庆市","潮州市","清远市","韶关市","揭阳市","阳江市","云浮市","茂名市","梅州市","汕尾市","济南市","青岛市","临沂市","济宁市","菏泽市","烟台市","泰安市","淄博市","潍坊市","日照市","威海市","滨州市","东营市","聊城市","德州市","莱芜市","枣庄市","苏州市","徐州市","盐城市","无锡市","南京市","南通市","连云港市","常州市","扬州市","镇江市","淮安市","泰州市","宿迁市","郑州市","南阳市","新乡市","安阳市","洛阳市","信阳市","平顶山市","周口市","商丘市","开封市","焦作市","驻马店市","濮阳市","三门峡市","漯河市","许昌市","鹤壁市","济源市","石家庄市","唐山市","保定市","邯郸市","邢台市","河北区","沧州市","秦皇岛市","张家口市","衡水市","廊坊市","承德市","温州市","宁波市","杭州市","台州市","嘉兴市","金华市","湖州市","绍兴市","舟山市","丽水市","衢州市","西安市","咸阳市","宝鸡市","汉中市","渭南市","安康市","榆林市","商洛市","延安市","铜川市","长沙市","邵阳市","常德市","衡阳市","株洲市","湘潭市","永州市","岳阳市","怀化市","郴州市","娄底市","益阳市","张家界市","湘西州","漳州市","泉州市","厦门市","福州市","莆田市","宁德市","三明市","南平市","龙岩市","江北区","渝北区","沙坪坝区","九龙坡区","万州区","永川市","南岸区","酉阳县","北碚区","涪陵区","秀山县","巴南区","渝中区","石柱县","忠县","合川市","大渡口区","开县","长寿区","荣昌县","云阳县","梁平县","潼南县","江津市","彭水县","璧山县","綦江县","大足县","黔江区","巫溪县","巫山县","垫江县","丰都县","武隆县","万盛区","铜梁县","南川市","奉节县","双桥区","城口县","和平区","北辰区","河北区","河西区","西青区","津南区","东丽区","武清区","宝坻区","红桥区","大港区","汉沽区","静海县","宁河县","塘沽区","蓟县","南开区","河东区","昆明市","红河州","大理州","文山州","德宏州","曲靖市","昭通市","楚雄州","保山市","玉溪市","丽江地区","临沧地区","思茅地区","西双版纳州","怒江州","迪庆州","成都市","绵阳市","广元市","达州市","南充市","德阳市","广安市","阿坝州","巴中市","遂宁市","内江市","凉山州","攀枝花市","乐山市","自贡市","泸州市","雅安市","宜宾市","资阳市","眉山市","甘孜州","贵港市","玉林市","北海市","南宁市","柳州市","桂林市","梧州市","钦州市","来宾市","河池市","百色市","贺州市","崇左市","防城港市","芜湖市","合肥市","六安市","宿州市","阜阳市","安庆市","马鞍山市","蚌埠市","淮北市","淮南市","宣城市","黄山市","铜陵市","亳州市","池州市","巢湖市","滁州市","三亚市","海口市","琼海市","文昌市","东方市","昌江县","陵水县","乐东县","五指山市","保亭县","澄迈县","万宁市","儋州市","临高县","白沙县","定安县","琼中县","屯昌县","南昌市","赣州市","上饶市","吉安市","九江市","新余市","抚州市","宜春市","景德镇市","萍乡市","鹰潭市武汉市","宜昌市","襄樊市","荆州市","恩施州","孝感市","黄冈市","十堰市","咸宁市","黄石市","仙桃市","随州市","天门市","荆门市","潜江市","鄂州市","神农架林区","太原市","大同市","运城市","长治市","晋城市","忻州市","临汾市","吕梁市","晋中市","阳泉市","朔州市","大连市","沈阳市","丹东市","辽阳市","葫芦岛市","锦州市","朝阳市","营口市","鞍山市","抚顺市","阜新市","本溪市","盘锦市","铁岭市","台北市","高雄市","台中市","新竹市","基隆市","台南市","嘉义市","齐齐哈尔市","哈尔滨市","大庆市","佳木斯市","双鸭山市","牡丹江市","鸡西市","黑河市","绥化市","鹤岗市","伊春市","大兴安岭地区","七台河市","赤峰市","包头市","通辽市","呼和浩特市","乌海市","鄂尔多斯市","呼伦贝尔市","兴安盟","巴彦淖尔盟","乌兰察布盟","锡林郭勒盟","阿拉善盟","贵阳市","黔东南州","黔南州","遵义市","黔西南州","毕节地区","铜仁地区","安顺市","六盘水市","兰州市","天水市","庆阳市","武威市","酒泉市","张掖市","陇南地区","白银市","定西地区","平凉市","嘉峪关市","临夏回族自治州","金昌市","甘南州","西宁市","海西州","海东地区","海北州","果洛州","玉树州","黄南藏族自治州","乌鲁木齐市","伊犁州","昌吉州","石河子市","哈密地区","阿克苏地区","巴音郭楞州","喀什地区","塔城地区","克拉玛依市","和田地区","阿勒泰州","吐鲁番地区","阿拉尔市","博尔塔拉州","五家渠市","克孜勒苏州","图木舒克市","拉萨市","山南地区","林芝地区","日喀则地区","阿里地区","昌都地区","那曲地区","吉林市","长春市","白山市","白城市","延边州","松原市","辽源市","通化市","四平市","银川市","吴忠市","中卫市","石嘴山市","固原市"
	};
	static String[] userNameList = {
			"曹操","曹丕","曹睿","曹芳","曹髦","曹奂","武宣卞皇后","文昭甄皇后","文德郭皇后","明悼毛皇后","明元郭皇后","董卓","李儒","李傕","郭汜","袁绍","麴义","田丰","沮授","颜良","文丑","淳于琼","审配","袁谭","袁熙","袁尚","高干","袁术","刘表","吕布","陈宫","高顺","臧洪","公孙瓒","陶谦","张杨","公孙度","公孙渊","张燕","张绣","张鲁","夏侯惇","韩浩","史涣","夏侯渊","曹仁","曹纯","曹洪","曹休","曹真","曹爽","夏侯尚","夏侯玄","荀彧","荀攸","贾诩","袁涣","张范","凉茂","国渊","田畴","王修","邴原","管宁","崔琰","毛玠","徐奕","何夔","邢颙","鲍勋","司马芝","钟繇","华歆","王朗","王肃","程昱","郭嘉","董昭","刘晔","蒋济","刘放","刘馥","司马朗","梁习","张既","温恢","贾逵","任峻","苏则","杜畿","杜恕","郑浑","仓慈","张辽","乐进","于禁","张郃","徐晃","朱灵","李典","李通","臧霸","文聘","吕虔","许褚","典韦","庞德","庞淯","阎温","曹彰","曹植","曹熊","曹昂","曹铄","曹冲","曹宇","曹林","曹峻","曹彪","曹协","曹蕤","曹霖","曹礼","曹邕","曹贡","曹俨","王粲","徐干","陈琳","阮瑀","应玚","刘桢","卫觊","刘廙","刘劭","傅嘏","桓阶","陈群","陈矫","徐宣","卫臻","卢毓","和洽","常林","杨俊","杜袭","赵俨","裴潜","韩暨","崔林","高柔","孙礼","王观","辛毗","杨阜","高堂隆","满宠","田豫","牵招","郭淮","徐邈","胡质","王昶","王基","王凌","毌丘俭","文钦","诸葛诞","邓艾","钟会","华佗","杜夔","朱建平","周宣","管辂","刘焉","刘璋","刘备","刘禅","甘皇后","吴氏","刘永","刘理","敬哀皇后","张皇后","刘璇","诸葛亮","关羽","张飞","马超","黄忠","赵云","庞统","法正","许靖","麋竺","糜芳","孙乾","简雍","伊籍","秦宓","董和","董允","董厥","刘巴","马良","马谡","陈震","蒋琬","费袆","陈祗","吕乂","吕凯","刘封","张松","彭羕","廖立","李严","刘琰","魏延","杨仪","霍峻","霍弋","王连","向朗","向宠","张裔","杨洪","费诗","王冲","杜微","周群","杜琼","许慈","孟光","来敏","尹默","李撰","谯周","郤正","黄权","邓方","李恢","马忠","王平","张嶷","姜维","邓芝","张翼","宗预","廖化","杨戏","吴懿","陈到","徐庶","夏侯霸","孙坚","孙策","孙权","孙亮","孙休","孙皓","刘繇","太史慈","士燮","吴夫人","吴景","徐琨","谢夫人","徐夫人","步练师","大懿皇后","潘皇后","敬怀皇后","全惠解","朱皇后","滕皇后","孙静","孙皎","孙奂","孙贲","孙辅","孙翊","孙匡","孙韶","孙桓","张昭","顾雍","诸葛瑾","步骘","张纮","严畯","程秉","阚泽","薛综","周瑜","鲁肃","吕蒙","程普","黄盖","韩当","吕岱","蒋钦","周泰","陈武","陈脩","陈表","董袭","甘宁","凌统","徐盛","潘璋","丁奉","朱治","朱然","朱绩","吕范","吕据","朱桓","朱异","虞翻","陆绩","张温","骆统","陆瑁","吾粲","朱据","陆逊","孙登","孙虑","孙和","孙霸","孙奋","贺齐","全琮","周鲂","锺离牧","潘濬","陆凯","是仪","胡综","吴范","刘惇","赵达","诸葛恪","滕胤","孙峻","孙綝","濮阳兴","王蕃","楼玄","贺邵","韦曜","华核",
			"林黛玉","贾元春","贾探春","李纨","妙玉","史湘云","王熙凤","贾巧姐","秦可卿","晴雯","麝月","袭人","鸳鸯","雪雁","紫鹃","碧痕","平儿","香菱","金钏","司棋","抱琴","赖大","焦大","王善保","周瑞","林之孝","乌进孝","包勇","吴贵","吴新登","邓好时","王柱儿","余信","庆儿","昭儿","兴儿","隆儿","坠儿","喜儿","寿儿","丰儿","住儿","小舍儿","李十儿","玉柱儿","贾敬","贾赦","贾政","贾宝玉","贾琏","贾珍","贾环","贾蓉","贾兰","贾芸","贾蔷","贾芹","琪官","芳官","藕官","蕊官","药官","玉官","宝官","龄官","茄官","艾官","豆官","葵官","妙玉","智能","智通","智善","圆信","大色空","净虚","彩屏","彩儿","彩凤","彩霞","彩鸾","彩明","彩云","贾元春","贾迎春","贾探春","贾惜春","贾宝玉","甄宝玉","薛宝琴","薛蟠","薛蝌","薛宝钗","薛宝琴","王夫人","王子腾","王仁","尤老娘","尤氏","尤二姐","尤三姐","贾蓉","贾兰","贾芸","贾芹，贾蔷","贾珍","贾琏","贾环","贾瑞","贾珠","宝玉","贾敬","贾赦","贾政","贾敏","贾代儒","贾代化","贾代修","贾代善","晴雯","金钏","鸳鸯","司棋","詹光","单聘仁","程日兴","王作梅","石呆子","张华","冯渊","张金哥","茗烟","扫红","锄药","伴鹤","小鹊","小红","小蝉","小舍儿","刘姥姥","马道婆","宋嬷嬷","张妈妈","秦锺","蒋玉菡","柳湘莲","东平王","乌进孝","冷子兴","山子野","方椿","载权","夏秉忠","周太监","裘世安","抱琴","司棋","侍书","入画","珍珠","琥珀","玻璃","翡翠","史湘云","翠缕","笑儿","篆儿","贾探春，侍画","翠墨","小蝉","贾宝玉，茗烟","袭人","晴雯",
			"宋江","卢俊义","吴用","公孙胜","关胜","林冲","秦明","呼延灼","花荣","柴进","李应","朱仝","鲁智深","武松","董平","张清","杨志","徐宁","索超","戴宗","刘唐","李逵","史进","穆弘","雷横","李俊","阮小二","张横","阮小五","张顺","阮小七","杨雄","石秀","解珍","解宝","燕青","","","姓名","朱武","黄信","孙立","宣赞","郝思文","韩滔","彭玘","单廷珪","魏定国","萧让","裴宣","欧鹏","邓飞","燕顺","杨林","凌振","蒋敬","吕方","郭盛","安道全","皇甫端","王英","扈三娘","鲍旭","樊瑞","孔明","孔亮","项充","李衮","金大坚","马麟","童威","童猛","孟康","侯健","陈达","杨春","郑天寿","陶宗旺","宋清","乐和","龚旺","丁得孙","穆春","曹正","宋万","杜迁","薛永","施恩","李忠","周通","汤隆","杜兴","邹渊","邹润","朱贵","朱富","蔡福","蔡庆","李立","李云","焦挺","石勇","孙新","顾大嫂","张青","孙二娘","王定六","郁保四","白胜","时迁","段景住",
			"唐僧","江流","唐三藏","陈玄奘","金蝉子","旃檀功德佛","孙悟空","孙行者","美猴王","齐天大圣","斗战胜佛","猪悟能","猪刚鬣","猪八戒","天蓬元帅","净坛使者","沙悟净","沙僧","沙和尚","卷帘大将","金身罗汉张氏","刘洪","李彪","法明","张稍","李定","崔珏","相良","刘全","皇后","刘母","刘妻","广智","广谋","高才","李四","红三","陈澄","陈清","杨妻","杨子","杨孙","寇洪","寇妻","寇梁","宼栋","寇铭","张旺","唐太宗","李世民","殷开山","殷温娇","满堂娇","袁天罡","袁守诚","房玄龄","杜如晦","徐世绩","徐茂公","许敬宗","马三宝","段志贤","程咬金","刘洪纪","胡敬德","秦叔宝","李建成","李元吉","高士廉","虞世南","张道源","张士衡","李淳风","薛仁贵","吴道子","玉华王","寇大宽","陈萼母","王左衙","李右衙","刘小二","李翠莲","李玉英","相良妻","刘伯钦","陈老者","眼看喜","耳听怒","鼻嗅爱","舌尝思","意见欲","身本忧","高太公","高香兰","高玉兰","高翠兰","王老者","百花娇","红百万","一秤金","陈关保","杨老者","李老者","王小二","赵寡妇","陈少保"
	};
	
	/**
	 * 
	 * @param type
	 * type:0 所有运营商随机取一个号码
	 * type:1 移动运营商号码随机取一个
	 * type:2 联通运营商号码随机取一个
	 * type:3 电信运营商号码随机取一个
	 * @return
	 */
	public static String getRandomPhone(int type){
		String[][] phone_suffix = {
			{
				//移动号码段
				"134","135","136","137","138","139","150","151","152","181","182","183","187","188",
				//联通号码段
				"130","131","132","155","156","185","186",
				//电信号码段
				"133","153","180","189"
			},
			{
				"134","135","136","137","138","139","150","151","152","181","182","183","187","188"
			},
			{
				"130","131","132","155","156","185","186"
			},
			{
				"133","153","180","189"
			}
		};
		while(true){
			String num = getRandom(getRandomString(phone_suffix[(type > 3) ? 0 : type]),8);
			if(num.length()<11){
				continue;
			}else{
				return num;
			}
		}
	}
	public static String getRandomName(){
		return getRandomString(userNameList);
	}
	public static String getRandomCity(){
		return getRandomString(cityNameList);
	}
	public static String getRandom(int n) {
		long lo = (long) Math.pow(10,n);
		Random r = new Random();
		while(true){
			long num = Math.abs(r.nextLong() % lo);
	        String s = String.valueOf(num);
	        if(s.length() < n){
	        	continue;
	        }else{
	        	return s;
	        }
		}
	}
	
	public static String getRandomItem(String[] items){
		int max=items.length;
        int min=0;
        Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;
        return items[s];
	}
	public static String getRandomItem(String items){
		String temp[]=items.split("\\|");
		return getRandomItem(temp);
	}
	public static String getRandomString(String prefix, int n){
		long lo = (long) Math.pow(10, n);
		Random r = new Random();
		while(true){
			long num = Math.abs(r.nextLong() % lo);
			if(String.valueOf(num).length() < n){
				continue;
			}else{
				String s = prefix.concat(String.valueOf(num));
				return s;
			}
		}
	}
	public static String getRandom(String prefix, int n){
		long lo = (long) Math.pow(10, n);
		Random r = new Random();
		while(true){
			long num = Math.abs(r.nextLong() % lo);
			if(String.valueOf(num).length() < n){
				continue;
			}else{
				String s = prefix.concat(String.valueOf(num));
				return s;
			}
		}
	}
	
	public static String getRandomString(String prefix, String format, int n){
		String num = getRandom(n);
		String s = "";
		if(format.toUpperCase().equals("YYYYMMDD")){
			s = prefix.concat(DateUtils.getDateStringNoHMS(new Date()).concat(num));
		}else if(format.toUpperCase().equals("YYYYMMDDHH")){
			s = prefix.concat(DateUtils.getDateStringHavingH(new Date()).concat(num));
		}else if(format.toUpperCase().equals("YYYYMMDDHHMM")){
			s = prefix.concat(DateUtils.getDateStringHavingHM(new Date()).concat(num));
		}else if(format.toUpperCase().equals("YYYYMMDDHHMMSS")){
			s = prefix.concat(DateUtils.getDateStringHavingHMS(new Date()).concat(num));
		}else if(format.toUpperCase().equals("YYYYMM")){
			s = prefix.concat(DateUtils.getDateStringHavingYM(new Date()).concat(num));
		}else if(format.toUpperCase().equals("YYYY")){
			s = prefix.concat(DateUtils.getDateStringHavingY(new Date()).concat(num));
		}
		return s;
	}
	public static String getRandom(String prefix, String format, int n){
		String num = getRandom(n);
		String s = "";
		if(format.toUpperCase().equals("YYYYMMDD")){
			s = prefix.concat(DateUtils.getDateStringNoHMS(new Date()).concat(num));
		}else if(format.toUpperCase().equals("YYYYMMDDHH")){
			s = prefix.concat(DateUtils.getDateStringHavingH(new Date()).concat(num));
		}else if(format.toUpperCase().equals("YYYYMMDDHHMM")){
			s = prefix.concat(DateUtils.getDateStringHavingHM(new Date()).concat(num));
		}else if(format.toUpperCase().equals("YYYYMMDDHHMMSS")){
			s = prefix.concat(DateUtils.getDateStringHavingHMS(new Date()).concat(num));
		}else if(format.toUpperCase().equals("YYYYMM")){
			s = prefix.concat(DateUtils.getDateStringHavingYM(new Date()).concat(num));
		}else if(format.toUpperCase().equals("YYYY")){
			s = prefix.concat(DateUtils.getDateStringHavingY(new Date()).concat(num));
		}
		return s;
	}
	
	
	
	public static String getRandomString(String[] str){
		int max=str.length;
        int min=0;
        Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;
        return str[s];
	}
	
	public static char getRandomChar(){
		String strStringType = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
		char[] chrCharArray = strStringType.toCharArray();
		int max=chrCharArray.length-1;
        int min=0;
        Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;
        return chrCharArray[s];
	}
	public static String getRandomChars(int n){
		String strStringType = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789-";
		char[] chrCharArray = strStringType.toCharArray();
		int max=chrCharArray.length-1;
        int min=0;
        Random random = new Random();
        String ss = "";
        for(int i=0; i< n; i++){
	        int s = random.nextInt(max)%(max-min+1) + min;
	        ss = ss.concat(String.valueOf(chrCharArray[s]));
        }
        return ss;
	}
	public static String getRandomNum(int start, int end){
		int i = (int)(start + Math.random()*(end - start + 1));
		return String.valueOf(i);
	}
	public static String getRandomNum(double start, double end){
		double i = (double)(start + Math.random()*(end - start + 1));
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(i);
	}
	public static String getRandomNum(int n) {
		long lo = (long) Math.pow(10,n);
		Random r = new Random();
		while(true){
			long num = Math.abs(r.nextLong() % lo);
	        String s = String.valueOf(num);
	        if(s.length() < n)
	        {
	        	continue;
	        }else{
	        	return s;
	        }
		}
	}
	public static void main(String[] args) {
		
		//System.out.println(getRandomChars(16));
		System.out.println(RandomUtils.getRandomItem("A|B|C|D|E|F"));
	}
}
