package profiles.domain;


public class ProfileDao {
    private Integer id;
    private String username;
    private String password;
    private RelatedPartyRefDao party;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RelatedPartyRefDao getParty() {
        return party;
    }

    public void setParty(RelatedPartyRefDao party) {
        this.party = party;
    }
}
