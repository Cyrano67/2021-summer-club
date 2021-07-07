# Register your models here.
import itertools
import random


class cartesian(object):
    def __init__(self):
        self._data_list = []

    def add_data(self, data=[]):  # 添加生成笛卡尔积的数据列表
        self._data_list.append(data)

    def build(self):  # 计算笛卡尔积
        blist = []
        for item in itertools.product(*self._data_list):
            tmp = ""
            for x in item:
                tmp+=x
            blist.append(tmp)
        return blist


def insert_clothes():
    f = open("./SqlPyScript/insert_clothes.txt", "w+",encoding = 'UTF-8')

    tag1 = ["折扣","新品"]
    tag2 = ["男士","女士"]
    tag3 = ["时尚","复古","老年","儿童"]
    tag4 = ["衬衣","卫衣","T恤","连衣裙","背心","短裤","裤衩","内裤","长裤","西裤","背带裤","牛仔裤","短裙","长裙","连身装","母子装",]
    car = cartesian()
    car.add_data(tag1)
    car.add_data(tag2)
    car.add_data(tag3)
    car.add_data(tag4)
    cname_list = car.build()
    # print(cname_list)

    brand_list = ["Nike","Adidas","donnakaran","Versace","BURBERRY","Givenchy"]
    color_list = ["红","绿","黑","白"]
    desc_list = ["运动","休闲","大码","修身","清仓","预定","海外","定制"]
    desc_sub_list = []  # 用于存放集合所有的子集
    for i in range(1 << len(desc_list)):  # 循环遍历0到2**n之间的每个数
        combo_list = ""  # 用于存放每个单独的循环中取出的子集
        for j in range(len(desc_list)):
            if i & (1 << j):  # 每一个数用&操作判断改为上是否有1
                combo_list += (desc_list[j])  # 有的话保存起来
        desc_sub_list.append(combo_list)
    # print(desc_sub_list)

    # exit()
    insert_sql = []
    for x in range(127):
        CID= str(x)
        CNAME = cname_list[x]
        PRICE = random.randint(50,500)
        BRAND_NAME = brand_list[random.randint(0,len(brand_list)-1)]
        COLOR = color_list[random.randint(0,len(color_list)-1)]
        DISCRIPTION = desc_sub_list[random.randint(0,len(desc_sub_list)/2)]
        PIC_ADDR = ""
        tstr = "INSERT INTO CLOTHES VALUES ({},\'{}\',{},\'{}\',\'{}\',\'{}\',\'{}\');".format(CID,CNAME,PRICE,BRAND_NAME,COLOR,DISCRIPTION,PIC_ADDR)
        # insert_sql.append(tstr)
        f.write(tstr+"\n")
        insert_sql.append(tstr)
    print(insert_sql)
    f.close()


def insert_user():
    first_name_array = [
        "赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "楮", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许", "何", "吕",
        "施",
        "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚",
        "范",
        "彭", "郎", "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳", "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛",
        "雷",
        "贺", "倪", "汤", "滕", "殷", "罗", "毕", "郝", "邬", "安", "常", "乐", "于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元",
        "卜",
        "顾", "孟", "平", "黄", "和", "穆", "萧", "尹", "姚", "邵", "湛", "汪", "祁", "毛", "禹", "狄", "米", "贝", "明", "臧", "计", "伏",
        "成",
        "佟", "万俟", "司马", "上官", "欧阳", "夏侯", "诸葛", "闻人", "东方", "赫连", "皇甫", "尉迟", "公羊", "澹台", "公冶", "宗政", "濮阳", "淳于", "单于"
    ]
    last_name_array = [
        "一", "乙", "二", "十", "丁", "厂", "七", "卜", "人", "入", "八", "九", "几", "儿", "了", "力", "乃", "刀", "又", "三",
        "于", "干", "亏", "士", "工", "土", "才", "寸", "下", "大", "丈", "与", "万", "上", "小", "口", "巾", "山", "千", "乞",
        "川", "亿", "个", "勺", "久", "凡", "及", "夕", "丸", "么", "广", "亡", "门", "义", "之", "尸", "弓", "己", "已", "子",
        "卫", "也", "女", "飞", "刃", "习", "叉", "马", "乡", "丰", "王", "井", "开", "夫", "天", "无", "元", "专", "云", "扎",
        "艺", "木", "五", "支", "厅", "不", "太", "犬", "区", "历", "尤", "友", "匹", "车", "巨", "牙", "屯", "比", "互", "切",
        "瓦", "止", "少", "日", "中", "冈", "贝", "内", "水", "见", "午", "牛", "手", "毛", "气", "升", "长", "仁", "什", "片",
        "仆", "化", "仇", "币", "仍", "仅", "斤", "爪", "反", "介", "父", "从", "今", "凶", "分", "乏", "公", "仓", "月", "氏",
        "勿", "欠", "风", "丹", "匀", "乌", "凤", "勾", "文", "六", "方", "火", "为", "斗", "忆", "订", "计", "户", "认", "心",
        "尺", "引", "丑", "巴", "孔", "队", "办", "以", "允", "予", "劝", "双", "书", "幻", "玉", "刊", "示", "末", "未", "击",
        "打", "巧", "正", "扑", "扒", "功", "扔", "去", "甘", "世", "古", "节", "本", "术", "可", "丙", "左", "厉", "右", "石",
        "布", "龙", "平", "灭", "轧", "东", "卡", "北", "占", "业", "旧", "帅", "归", "且", "旦", "目", "叶", "甲", "申", "叮",
        "电", "号", "田", "由", "史", "只", "央", "兄", "叼", "叫", "另", "叨", "叹", "四", "生", "失", "禾", "丘", "付", "仗",
        "代", "仙", "们", "仪", "白", "仔", "他", "斥", "瓜", "乎", "丛", "令", "用", "甩", "印", "乐", "句", "匆", "册", "犯",
        "外", "处", "冬", "鸟", "务", "包", "饥", "主", "市", "立", "闪", "兰", "半", "汁", "汇", "头", "汉", "宁", "穴", "它",
        "讨", "写", "让", "礼", "训", "必", "议", "讯", "记", "永", "司", "尼", "民", "出", "辽", "奶", "奴", "加", "召", "皮",
        "边", "发", "孕", "圣", "对", "台", "矛", "纠", "母", "幼", "丝", "式", "刑", "动", "扛", "寺", "吉", "扣", "考", "托",
        "老", "执", "巩", "圾", "扩", "扫", "地", "扬", "场", "耳", "共", "芒", "亚", "芝", "朽", "朴", "机", "权", "过", "臣",
        "再", "协", "西", "压", "厌", "在", "有", "百", "存", "而", "页", "匠", "夸", "夺", "灰", "达", "列", "死", "成", "夹",
        "轨", "邪", "划", "迈", "毕", "至", "此", "贞", "师", "尘", "尖", "劣", "光", "当", "早", "吐", "吓", "虫", "曲", "团",
        "同", "吊", "吃", "因", "吸", "吗", "屿", "帆", "岁", "回", "岂", "刚", "则", "肉", "网", "年", "朱", "先", "丢", "舌",
        "竹", "迁", "乔", "伟", "传", "乒", "乓", "休", "伍", "伏", "优", "伐", "延", "件", "任", "伤", "价", "份", "华", "仰",
        "仿", "伙", "伪", "自", "血", "向", "似", "后", "行", "舟", "全", "会", "杀", "合", "兆", "企", "众", "爷", "伞", "创",
        "肌", "朵", "杂", "危", "旬", "旨", "负", "各", "名", "多", "争", "色", "壮", "冲", "冰", "庄", "庆", "亦", "刘", "齐",
        "交", "次", "衣", "产", "决", "充", "妄", "闭", "问", "闯", "羊", "并", "关", "米", "灯", "州", "汗", "污", "江", "池",
        "汤", "忙", "兴", "宇", "守", "宅", "字", "安", "讲", "军", "许", "论", "农", "讽", "设", "访", "寻", "那", "迅", "尽",
        "导", "异", "孙", "阵", "阳", "收", "阶", "阴", "防", "奸", "如", "妇", "好", "她", "妈", "戏", "羽", "观", "欢", "买",
        "红", "纤", "级", "约", "纪", "驰", "巡", "寿", "弄", "麦", "形", "进", "戒", "吞", "远", "违", "运", "扶", "抚", "坛",
        "技", "坏", "扰", "拒", "找", "批", "扯", "址", "走", "抄", "坝", "贡", "攻", "赤", "折", "抓", "扮", "抢", "孝", "均",
        "抛", "投", "坟", "抗", "坑", "坊", "抖", "护", "壳", "志", "扭", "块", "声", "把", "报", "却", "劫", "芽", "花", "芹",
        "芬", "苍", "芳", "严", "芦", "劳", "克", "苏", "杆", "杠", "杜", "材", "村", "杏", "极", "李", "杨", "求", "更", "束",
        "豆", "两", "丽", "医", "辰", "励", "否", "还", "歼", "来", "连", "步", "坚", "旱", "盯", "呈", "时", "吴", "助", "县",
        "里", "呆", "园", "旷", "围", "呀", "吨", "足", "邮", "男", "困", "吵", "串", "员", "听", "吩", "吹", "呜", "吧", "吼",
        "别", "岗", "帐", "财", "针", "钉", "告", "我", "乱", "利", "秃", "秀", "私", "每", "兵", "估", "体", "何", "但", "伸",
        "作", "伯", "伶", "佣", "低", "你", "住", "位", "伴", "身", "皂", "佛", "近", "彻", "役", "返", "余", "希", "坐", "谷",
        "妥", "含", "邻", "岔", "肝", "肚", "肠", "龟", "免", "狂", "犹", "角", "删", "条", "卵", "岛", "迎", "饭", "饮", "系",
        "言", "冻", "状", "亩", "况", "床", "库", "疗", "应", "冷", "这", "序", "辛", "弃", "冶", "忘", "闲", "间", "闷", "判",
        "灶", "灿", "弟", "汪", "沙", "汽", "沃", "泛", "沟", "没", "沈", "沉", "怀", "忧", "快", "完", "宋", "宏", "牢", "究",
        "穷", "灾", "良", "证", "启", "评", "补", "初", "社", "识", "诉", "诊", "词", "译", "君", "灵", "即", "层", "尿", "尾",
        "迟", "局", "改", "张", "忌", "际", "陆", "阿", "陈", "阻", "附", "妙", "妖", "妨", "努", "忍", "劲", "鸡", "驱", "纯",
        "纱", "纳", "纲", "驳", "纵", "纷", "纸", "纹", "纺", "驴", "纽", "奉", "玩", "环", "武", "青", "责", "现", "表", "规",
        "抹", "拢", "拔", "拣", "担", "坦", "押", "抽", "拐", "拖", "拍", "者", "顶", "拆", "拥", "抵", "拘", "势", "抱", "垃",
        "拉", "拦", "拌", "幸", "招", "坡", "披", "拨", "择", "抬", "其", "取", "苦", "若", "茂", "苹", "苗", "英", "范", "直",
        "茄", "茎", "茅", "林", "枝", "杯", "柜", "析", "板", "松", "枪", "构", "杰", "述", "枕", "丧", "或", "画", "卧", "事",
        "刺", "枣", "雨", "卖", "矿", "码", "厕", "奔", "奇", "奋", "态", "欧", "垄", "妻", "轰", "顷", "转", "斩", "轮", "软",
        "到", "非", "叔", "肯", "齿", "些", "虎", "虏", "肾", "贤", "尚", "旺", "具", "果", "味", "昆", "国", "昌", "畅", "明",
        "易", "昂", "典", "固", "忠", "咐", "呼", "鸣", "咏", "呢", "岸", "岩", "帖", "罗", "帜", "岭", "凯", "败", "贩", "购",
        "图", "钓", "制", "知", "垂", "牧", "物", "乖", "刮", "秆", "和", "季", "委", "佳", "侍", "供", "使", "例", "版", "侄",
        "侦", "侧", "凭", "侨", "佩", "货", "依", "的", "迫", "质", "欣", "征", "往", "爬", "彼", "径", "所", "舍", "金", "命",
        "斧", "爸", "采", "受", "乳", "贪", "念", "贫", "肤", "肺", "肢", "肿", "胀", "朋", "股", "肥", "服", "胁", "周", "昏",
        "鱼", "兔", "狐", "忽", "狗", "备", "饰", "饱", "饲", "变", "京", "享", "店", "夜", "庙", "府", "底", "剂", "郊", "废",
        "净", "盲", "放", "刻", "育", "闸", "闹", "郑", "券", "卷", "单", "炒", "炊", "炕", "炎", "炉", "沫", "浅", "法", "泄",
        "河", "沾", "泪", "油", "泊", "沿", "泡", "注", "泻", "泳", "泥", "沸", "波", "泼", "泽", "治", "怖", "性", "怕", "怜",
        "怪", "学", "宝", "宗", "定", "宜", "审", "宙", "官", "空", "帘", "实", "试", "郎", "诗", "肩", "房", "诚", "衬", "衫",
        "视", "话", "诞", "询", "该", "详", "建", "肃", "录", "隶", "居", "届", "刷", "屈", "弦", "承", "孟", "孤", "陕", "降",
        "限", "妹", "姑", "姐", "姓", "始", "驾", "参", "艰", "线", "练", "组", "细", "驶", "织", "终", "驻", "驼", "绍", "经",
        "贯", "奏", "春", "帮", "珍", "玻", "毒", "型", "挂", "封", "持", "项", "垮", "挎", "城", "挠", "政", "赴", "赵", "挡",
    ]
    """
    array length
    """
    f = open("./SqlPyScript/insert_users.txt", "w+",encoding = 'UTF-8')

    for x in range(0, 100):
        first_name = first_name_array[random.randint(0, len(first_name_array)-1)]
        last_name = ''.join(last_name_array[random.randint(0, len(last_name_array))] for i in range(random.randint(1, 2)))
        fullname = first_name + last_name
        UID= str(x)
        UNAME = fullname
        PHONE = str(random.randint(100000,199999)) + str(random.randint(10000,99999))
        PASSWORD = PHONE
        EMAIL = PHONE + "@cqu.edu.cn"
        ROLE = "1"
        tstr = "INSERT INTO USER_LIST VALUES ({},\'{}\',\'{}\',\'{}\',\'{}\',{});".format(UID,UNAME,PASSWORD,EMAIL,PHONE,ROLE)
        # insert_sql.append(tstr)
        f.write(tstr+"\n")
        # print(tstr)

    f.close()

insert_clothes()
insert_user()
