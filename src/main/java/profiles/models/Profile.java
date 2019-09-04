package profiles.models;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name="PROFILE")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated product ID")
    private Integer id;
    @ApiModelProperty(notes = "The username")
    private String username;
    @ApiModelProperty(notes = "The password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        @JoinColumn(name = "party_id")
    private RelatedPartyRef party;

    public Integer getId() { return id; }
    public void setId(Integer id) {this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public RelatedPartyRef getParty() { return party; }
    public void setParty(RelatedPartyRef party) { this.party = party; }

}
