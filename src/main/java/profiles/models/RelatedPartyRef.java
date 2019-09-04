package profiles.models;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name="RELATED_PARTY_REF")
public class RelatedPartyRef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated product ID")
    private Integer table_id;

    private Integer id;

    private String href;
    private String name;

    public Integer getTable_id() {
        return table_id;
    }
    public void setTable_id(Integer table_id) {
        this.table_id = table_id;
    }

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
