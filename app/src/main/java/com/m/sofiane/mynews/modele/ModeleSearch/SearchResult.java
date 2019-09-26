package com.m.sofiane.mynews.modele.ModeleSearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * created by Sofiane M. 2019-08-25
 */
public class SearchResult {

        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("copyright")
        @Expose
        private String copyright;
        @SerializedName("response")
        @Expose
        private  Response response = null;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCopyright() {
            return copyright;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public  Response getResponse() {
            return response;
        }

        public void setResponse( Response response) {
            this.response = response;
        }

        public class Response {

            @SerializedName("docs")
            @Expose
            private List<Doc> docs = null;
            @SerializedName("meta")
            @Expose
            private Meta meta;

            public List<Doc> getDocs() {
                return docs;
            }

            public void setDocs(List<Doc> docs) {
                this.docs = docs;
            }

            public Meta getMeta() {
                return meta;
            }

            public void setMeta(Meta meta) {
                this.meta = meta;
            }
        }

        public class Meta {

            @SerializedName("hits")
            @Expose
            private Integer hits;
            @SerializedName("offset")
            @Expose
            private Integer offset;
            @SerializedName("time")
            @Expose
            private Integer time;

            public Integer getHits() {
                return hits;
            }

            public void setHits(Integer hits) {
                this.hits = hits;
            }

            public Integer getOffset() {
                return offset;
            }

            public void setOffset(Integer offset) {
                this.offset = offset;
            }

            public Integer getTime() {
                return time;
            }

            public void setTime(Integer time) {
                this.time = time;
            }

        }

        public class Blog {}

        public class Byline {

            @SerializedName("original")
            @Expose
            private String original;
            @SerializedName("person")
            @Expose
            private List<Person> person = null;
            @SerializedName("organization")
            @Expose
            private Object organization;

            public String getOriginal() {
                return original;
            }

            public void setOriginal(String original) {
                this.original = original;
            }

            public List<Person> getPerson() {
                return person;
            }

            public void setPerson(List<Person> person) {
                this.person = person;
            }

            public Object getOrganization() {
                return organization;
            }

            public void setOrganization(Object organization) {
                this.organization = organization;
            }

        }

        public class Headline {

            @SerializedName("main")
            @Expose
            private String main;
            @SerializedName("kicker")
            @Expose
            private String kicker;
            @SerializedName("content_kicker")
            @Expose
            private Object contentKicker;
            @SerializedName("print_headline")
            @Expose
            private Object printHeadline;
            @SerializedName("name")
            @Expose
            private Object name;
            @SerializedName("seo")
            @Expose
            private Object seo;
            @SerializedName("sub")
            @Expose
            private Object sub;

            public String getMain() {
                return main;
            }

            public void setMain(String main) {
                this.main = main;
            }

            public String getKicker() {
                return kicker;
            }

            public void setKicker(String kicker) {
                this.kicker = kicker;
            }

            public Object getContentKicker() {
                return contentKicker;
            }

            public void setContentKicker(Object contentKicker) {
                this.contentKicker = contentKicker;
            }

            public Object getPrintHeadline() {
                return printHeadline;
            }

            public void setPrintHeadline(Object printHeadline) {
                this.printHeadline = printHeadline;
            }

            public Object getName() {
                return name;
            }

            public void setName(Object name) {
                this.name = name;
            }

            public Object getSeo() {
                return seo;
            }

            public void setSeo(Object seo) {
                this.seo = seo;
            }

            public Object getSub() {
                return sub;
            }

            public void setSub(Object sub) {
                this.sub = sub;
            }

        }

        public class Keyword {

            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("value")
            @Expose
            private String value;
            @SerializedName("rank")
            @Expose
            private Integer rank;
            @SerializedName("major")
            @Expose
            private Object major;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public Integer getRank() {
                return rank;
            }

            public void setRank(Integer rank) {
                this.rank = rank;
            }

            public Object getMajor() {
                return major;
            }

            public void setMajor(Object major) {
                this.major = major;
            }

        }

        public class Legacy {

            @SerializedName("thumbnailheight")
            @Expose
            private String thumbnailheight;
            @SerializedName("thumbnail")
            @Expose
            private String thumbnail;
            @SerializedName("thumbnailwidth")
            @Expose
            private String thumbnailwidth;

            public String getThumbnailheight() {
                return thumbnailheight;
            }

            public void setThumbnailheight(String thumbnailheight) {
                this.thumbnailheight = thumbnailheight;
            }

            public String getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(String thumbnail) {
                this.thumbnail = thumbnail;
            }

            public String getThumbnailwidth() {
                return thumbnailwidth;
            }

            public void setThumbnailwidth(String thumbnailwidth) {
                this.thumbnailwidth = thumbnailwidth;
            }

        }

        public class Person {

            @SerializedName("firstname")
            @Expose
            private String firstname;
            @SerializedName("middlename")
            @Expose
            private Object middlename;
            @SerializedName("lastname")
            @Expose
            private String lastname;
            @SerializedName("qualifier")
            @Expose
            private Object qualifier;
            @SerializedName("title")
            @Expose
            private Object title;
            @SerializedName("role")
            @Expose
            private String role;
            @SerializedName("organization")
            @Expose
            private String organization;
            @SerializedName("rank")
            @Expose
            private Integer rank;

            public String getFirstname() {
                return firstname;
            }

            public void setFirstname(String firstname) {
                this.firstname = firstname;
            }

            public Object getMiddlename() {
                return middlename;
            }

            public void setMiddlename(Object middlename) {
                this.middlename = middlename;
            }

            public String getLastname() {
                return lastname;
            }

            public void setLastname(String lastname) {
                this.lastname = lastname;
            }

            public Object getQualifier() {
                return qualifier;
            }

            public void setQualifier(Object qualifier) {
                this.qualifier = qualifier;
            }

            public Object getTitle() {
                return title;
            }

            public void setTitle(Object title) {
                this.title = title;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }

            public String getOrganization() {
                return organization;
            }

            public void setOrganization(String organization) {
                this.organization = organization;
            }

            public Integer getRank() {
                return rank;
            }

            public void setRank(Integer rank) {
                this.rank = rank;
            }

        }

        public class Doc {

            @SerializedName("web_url")
            @Expose
            private String webUrl;
            @SerializedName("snippet")
            @Expose
            private String snippet;
            @SerializedName("print_page")
            @Expose
            private String printPage;
            @SerializedName("blog")
            @Expose
            private Blog blog;
            @SerializedName("source")
            @Expose
            private String source;
            @SerializedName("multimedia")
            @Expose
            private List<Multimedium> multimedia = null;
            @SerializedName("headline")
            @Expose
            private Headline headline;
            @SerializedName("keywords")
            @Expose
            private List<Keyword> keywords = null;
            @SerializedName("pub_date")
            @Expose
            private String pubDate;
            @SerializedName("document_type")
            @Expose
            private String documentType;
            @SerializedName("news_desk")
            @Expose
            private String newsDesk;
            @SerializedName("byline")
            @Expose
            private Byline byline;
            @SerializedName("type_of_material")
            @Expose
            private String typeOfMaterial;
            @SerializedName("_id")
            @Expose
            private String id;
            @SerializedName("word_count")
            @Expose
            private Integer wordCount;
            @SerializedName("score")
            @Expose
            private Float score;
            @SerializedName("abstract")
            @Expose
            private String _abstract;
            @SerializedName("section_name")
            @Expose
            private String sectionName;
            @SerializedName("subsection_name")
            @Expose
            private String subsection;

            public String getWebUrl() {
                return webUrl;
            }

            public void setWebUrl(String webUrl) {
                this.webUrl = webUrl;
            }

            public String getSnippet() {
                return snippet;
            }

            public void setSnippet(String snippet) {
                this.snippet = snippet;
            }

            public String getPrintPage() {
                return printPage;
            }

            public void setPrintPage(String printPage) {
                this.printPage = printPage;
            }

            public Blog getBlog() {
                return blog;
            }

            public void setBlog(Blog blog) {
                this.blog = blog;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public List<Multimedium> getMultimedia() {
                return multimedia;
            }

            public void setMultimedia(List<Multimedium> multimedia) {
                this.multimedia = multimedia;
            }

            public Headline getHeadline() {
                return headline;
            }

            public void setHeadline(Headline headline) {
                this.headline = headline;
            }

            public List<Keyword> getKeywords() {
                return keywords;
            }

            public void setKeywords(List<Keyword> keywords) {
                this.keywords = keywords;
            }

            public String getPubDate() {
                return pubDate;
            }

            public void setPubDate(String pubDate) {
                this.pubDate = pubDate;
            }

            public String getDocumentType() {
                return documentType;
            }

            public void setDocumentType(String documentType) {
                this.documentType = documentType;
            }

            public String getNewsDesk() {
                return newsDesk;
            }

            public void setNewsDesk(String newsDesk) {
                this.newsDesk = newsDesk;
            }

            public Byline getByline() {
                return byline;
            }

            public void setByline(Byline byline) {
                this.byline = byline;
            }

            public String getTypeOfMaterial() {
                return typeOfMaterial;
            }

            public void setTypeOfMaterial(String typeOfMaterial) {
                this.typeOfMaterial = typeOfMaterial;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public Integer getWordCount() {
                return wordCount;
            }

            public void setWordCount(Integer wordCount) {
                this.wordCount = wordCount;
            }

            public Float getScore() {
                return score;
            }

            public void setScore(Float score) {
                this.score = score;
            }

            public String getAbstract() {
                return _abstract;
            }

            public void setAbstract(String _abstract) {
                this._abstract = _abstract;
            }

            public String getSectionName() {
                return sectionName;
            }

            public String getSubsection() {
                return subsection;
            }

            public void setSectionName(String sectionName) {
                this.sectionName = sectionName;
            }

    public void setSubsection(String subsection) {
        this.subsection = subsection;
    }

        public class Multimedium {

            @SerializedName("rank")
            @Expose
            private Integer rank;
            @SerializedName("subtype")
            @Expose
            private String subtype;
            @SerializedName("caption")
            @Expose
            private Object caption;
            @SerializedName("credit")
            @Expose
            private Object credit;
            @SerializedName("type")
            @Expose
            private String type;
            @SerializedName("url")
            @Expose
            private String url;
            @SerializedName("height")
            @Expose
            private Integer height;
            @SerializedName("width")
            @Expose
            private Integer width;
            @SerializedName("legacy")
            @Expose
            private Legacy legacy;
            @SerializedName("subType")
            @Expose
            private String subType;
            @SerializedName("crop_name")
            @Expose
            private Object cropName;

            public Integer getRank() {
                return rank;
            }

            public void setRank(Integer rank) {
                this.rank = rank;
            }

            public String getSubtype() {
                return subtype;
            }

            public void setSubtype(String subtype) {
                this.subtype = subtype;
            }

            public Object getCaption() {
                return caption;
            }

            public void setCaption(Object caption) {
                this.caption = caption;
            }

            public Object getCredit() {
                return credit;
            }

            public void setCredit(Object credit) {
                this.credit = credit;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public Integer getHeight() {
                return height;
            }

            public void setHeight(Integer height) {
                this.height = height;
            }

            public Integer getWidth() {
                return width;
            }

            public void setWidth(Integer width) {
                this.width = width;
            }

            public Legacy getLegacy() {
                return legacy;
            }

            public void setLegacy(Legacy legacy) {
                this.legacy = legacy;
            }

            public String getSubType() {
                return subType;
            }

            public void setSubType(String subType) {
                this.subType = subType;
            }

            public Object getCropName() {
                return cropName;
            }

            public void setCropName(Object cropName) {
                this.cropName = cropName;
            }

        }




    }}

/**


    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("adx_keywords")
    @Expose
    private String adxKeywords;
    @SerializedName("column")
    @Expose
    private Object column;
    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("byline")
    @Expose
    private String byline;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("abstract")
    @Expose
    private String _abstract;
    @SerializedName("published_date")
    @Expose
    private String publishedDate;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("asset_id")
    @Expose
    private long assetId;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("media")
    @Expose
    private List<Medium> medium = null;
    @SerializedName("multimedia")
    @Expose
    private List<Multimedia.Multimedium> multimedia = null;
    @SerializedName("short_url")
    @Expose
    private String shortUrl;
    @SerializedName("subsection")
    @Expose
    private String subsection;
    @SerializedName("web_url")
    @Expose
    private String webUrl;
    @SerializedName("snippet")
    @Expose
    private String snippet;
    @SerializedName("pub_date")
    @Expose
    private String pubDate;
    @SerializedName("score")
    @Expose
    private Double score;
    @SerializedName("headline")
    @Expose
    private News.Headline headline;

    private String mshortUrl;
    private String mTitle;


    public SearchResult(String mmshortUrl, String mmTitle) {
        mshortUrl = mmshortUrl;
        mTitle = mmTitle;
        }

    public String getUrl() {
        if (url == null){
            return webUrl;
        } else {
            return url;
        }
    }
        public void setUrl(String url) {
            this.url = url;
        }
        public void setAdxKeywords(String adxKeywords) {
            this.adxKeywords = adxKeywords;
        }
        public void setByline(String byline) {
            this.byline = byline;
        }
        public void setSection(String section) {
            this.section = section;
        }
        public void setType(String type) {
            this.type = type;
        }
        public void setSource(String source) {
            this.source = source;
        }
        public void setPublishedDate(String publishedDate) {
            this.publishedDate = publishedDate;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public void setMultimedia(List<Multimedia.Multimedium> multimedia) {
            this.multimedia = multimedia;
        }
        public void setMedia(List<Medium> medium) {
            this.medium = medium;
        }
    public String getAdxKeywords() {
        return adxKeywords;
    }
    public Object getColumn() {
        return column;
    }
    public String getSection() {
        return section;
    }
    public String getByline() {
        return byline;
    }
    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getAbstract() {
        return _abstract;
    }
    public String getPublishedDate() {
        return publishedDate;
    }
    public String getSource() {
        return source;
    }

    public long getId() {
        return id;
    }
    public long getAssetId() {
        return assetId;
    }
    public Integer getViews() {
        return views;
    }

    public List<Medium> getMedium() {
        return medium;
    }
    public List<Multimedia.Multimedium> getMultimedia() {
        return multimedia;
    }


    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getSubsection() {
        return subsection;
    }

    public void setSubsection(String subsection) {
        this.subsection = subsection;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public News.Headline getHeadline() {
        return headline;
    }

    public void setHeadline(News.Headline headline) {
        this.headline = headline;
    }
}


    **/