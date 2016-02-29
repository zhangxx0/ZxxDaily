package com.xinxin.zxxdaily.model;

import java.util.List;

/**
 * Created by xinxin on 2016年2月27日21:39:57
 * 罪行消息实体类
 */
public class Latest {


    /**
     * date : 20160227
     * stories : [{"images":["http://pic3.zhimg.com/38c546910de351fbebfc98bfb00df04e.jpg"],"type":0,"id":7916119,"ga_prefix":"022721","title":"7 年，她被囚禁、性虐，还生下了一个孩子"},{"images":["http://pic1.zhimg.com/13d29b3baa9b1d6458ef4a94ce6e9910.jpg"],"type":0,"id":7928843,"ga_prefix":"022720","title":"「不是很懂你们二次元」，可能是你还不懂那些 ACG 黑话"},{"images":["http://pic2.zhimg.com/2492970ff6d86468dfe8f2d7179c4019.jpg"],"type":0,"id":7911665,"ga_prefix":"022719","title":"医生也爱想「丧尸会不会真的出现」这事，还想出了些成果"},{"images":["http://pic3.zhimg.com/9768f9588e40f4330054e115128b4156.jpg"],"type":0,"id":7928517,"ga_prefix":"022718","title":"我用自己做实验，过了三个月「最舒服」的生活，结果\u2026\u2026"},{"images":["http://pic4.zhimg.com/21018494ee4a495cfbcc5ee01a776f47.jpg"],"type":0,"id":7927765,"ga_prefix":"022717","title":"这个时候别调手表，不然会发生可怕的事"},{"title":"教你老少皆宜特好学的运动，冲浪、水上瑜伽都能玩","ga_prefix":"022716","images":["http://pic4.zhimg.com/c285431b225789d0cd4064a4352c12ef.jpg"],"multipic":true,"type":0,"id":7919285},{"images":["http://pic1.zhimg.com/b4443d0eb9a46ff55b8d60907a54efec.jpg"],"type":0,"id":7923125,"ga_prefix":"022715","title":"先别吐，口香糖里的胶确实是塑料和橡胶"},{"images":["http://pic2.zhimg.com/8d7ca3434a850183e81d93b9170e47f5.jpg"],"type":0,"id":7924610,"ga_prefix":"022714","title":"特别实用的老司机经验总结"},{"images":["http://pic2.zhimg.com/424f0327ade31a5eeb3a5ba12f5d2419.jpg"],"type":0,"id":7914360,"ga_prefix":"022713","title":"目前最尖锐的「针」，针尖只有一个原子"},{"images":["http://pic3.zhimg.com/c25bf30b194914e6baa29d6b1ff71c06.jpg"],"type":0,"id":7746166,"ga_prefix":"022712","title":"大误 · 拿走妙蛙种子背上的种子，会发生什么？"},{"images":["http://pic1.zhimg.com/cd8d80533edadf618733afad8dc897cc.jpg"],"type":0,"id":7919737,"ga_prefix":"022711","title":"不用怀疑，更好的抗癌药已经到来"},{"images":["http://pic1.zhimg.com/80498ee30ed4ee3b7aa75b7ff0f24cb8.jpg"],"type":0,"id":7918433,"ga_prefix":"022710","title":"历史上真的有人尝过糖尿病患者的尿液，没错，是甜的"},{"images":["http://pic3.zhimg.com/d4a6a2f96bb79b82e260adf02310d2a2.jpg"],"type":0,"id":7902353,"ga_prefix":"022709","title":"对婚姻来说，孩子的出世会影响夫妻之间的感情吗？"},{"images":["http://pic3.zhimg.com/b06a949254e363da4dc88ae457bc123a.jpg"],"type":0,"id":7924236,"ga_prefix":"022708","title":"中国科学家终于在「体外」获得功能性精子"},{"images":["http://pic3.zhimg.com/4e6c23bd3fe1efd0d484a1a0747af716.jpg"],"type":0,"id":7880014,"ga_prefix":"022707","title":"为什么只有「普通物理」，没有「史诗物理」、「传说物理」？"},{"title":"我居然被一档央视出品，主持人是《走进科学》同款的节目圈粉了","ga_prefix":"022707","images":["http://pic3.zhimg.com/a0b1b288fdf9960918d7258d8fd85a26.jpg"],"multipic":true,"type":0,"id":7914389},{"images":["http://pic4.zhimg.com/69c6dffe6474806ca10dc2f81b08400b.jpg"],"type":0,"id":7838193,"ga_prefix":"022707","title":"周末干什么 · 学点撩妹技能"},{"images":["http://pic4.zhimg.com/10de9f70f1f7c74b681ea781c117304f.jpg"],"type":0,"id":7926237,"ga_prefix":"022707","title":"读读日报 24 小时热门：中国在北美的「富二代」们"},{"images":["http://pic4.zhimg.com/6879ddd64210c8690d60f4b49bb35e5b.jpg"],"type":0,"id":7903941,"ga_prefix":"022706","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic2.zhimg.com/a1568aa0f1cc686f694e593cc5360415.jpg","type":0,"id":7928517,"ga_prefix":"022718","title":"我用自己做实验，过了三个月「最舒服」的生活，结果\u2026\u2026"},{"image":"http://pic1.zhimg.com/4ba4b8303b77bc7345767886a3e83894.jpg","type":0,"id":7838193,"ga_prefix":"022707","title":"周末干什么 · 学点撩妹技能"},{"image":"http://pic2.zhimg.com/24a0012e73bc35561a2812a591b0bf1d.jpg","type":0,"id":7914389,"ga_prefix":"022707","title":"我居然被一档央视出品，主持人是《走进科学》同款的节目圈粉了"},{"image":"http://pic3.zhimg.com/25e2d99e6028f708bd6aacf862eb2792.jpg","type":0,"id":7924610,"ga_prefix":"022714","title":"特别实用的老司机经验总结"},{"image":"http://pic4.zhimg.com/57b2be5b4e8fd077a772924db90aa577.jpg","type":0,"id":7924236,"ga_prefix":"022708","title":"中国科学家终于在「体外」获得功能性精子"}]
     */
    // 日期
    private String date;
    /**
     * images : ["http://pic3.zhimg.com/38c546910de351fbebfc98bfb00df04e.jpg"]
     * type : 0
     * id : 7916119
     * ga_prefix : 022721
     * title : 7 年，她被囚禁、性虐，还生下了一个孩子
     */
    // 今天的所有日报
    private List<StoriesEntity> stories;
    /**
     * image : http://pic2.zhimg.com/a1568aa0f1cc686f694e593cc5360415.jpg
     * type : 0
     * id : 7928517
     * ga_prefix : 022718
     * title : 我用自己做实验，过了三个月「最舒服」的生活，结果……
     */
    // 今天的置顶日报
    private List<TopStoriesEntity> top_stories;

    public void setDate(String date) {
        this.date = date;
    }

    public void setStories(List<StoriesEntity> stories) {
        this.stories = stories;
    }

    public void setTop_stories(List<TopStoriesEntity> top_stories) {
        this.top_stories = top_stories;
    }

    public String getDate() {
        return date;
    }

    public List<StoriesEntity> getStories() {
        return stories;
    }

    public List<TopStoriesEntity> getTop_stories() {
        return top_stories;
    }



    public static class TopStoriesEntity {
        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public void setImage(String image) {
            this.image = image;
        }

        public void setType(int type) {
            this.type = type;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage() {
            return image;
        }

        public int getType() {
            return type;
        }

        public int getId() {
            return id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public String getTitle() {
            return title;
        }
    }
}
