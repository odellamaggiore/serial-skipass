package ch.serial.game.skipass.infrastructure.dto;

import java.util.ArrayList;
import java.util.List;

public class SkiPassDto {

    private Long idSkiPass;
    private String ownerLastName;
    private String ownerFirstName;
    private List<SkiPassDto> sessions = new ArrayList<>();

    public Long getIdSkiPass() {
        return idSkiPass;
    }

    public void setIdSkiPass(Long id) {
        this.idSkiPass = id;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String lastName) {
        this.ownerLastName = lastName;
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(String firstName) {
        this.ownerFirstName = firstName;
    }

    public List<SkiPassDto> getSessions() {
        return sessions;
    }

    public void setSessions(List<SkiPassDto> sessions) {
        this.sessions = sessions;
    }

}

