package profiles.domain;

public class RelatedPartyRefDao {
    private Integer id;
    private String href;
    private String name;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }
    public void setHref(String href) { this.href=href; }

    public String getName() {
        return name;
    }
    public void setName(String name) { this.name=name; }
}
