package profiles.domain;

import profiles.models.RelatedPartyRef;

public class LoginDao {
    private boolean loginStatus;

    private RelatedPartyRefDao party;

    public boolean getLoginStatus() {
        return loginStatus;
    }
    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }


    public RelatedPartyRefDao getParty() {return party; }
    public void setParty(RelatedPartyRefDao party) {
        this.party = party;
    }
}
