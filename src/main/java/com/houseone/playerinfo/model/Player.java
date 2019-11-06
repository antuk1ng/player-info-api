package com.houseone.playerinfo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Set;

@Data
@Document(collection = "player")
public class Player {

    @Id
    private String id;

    private PlayerName name;
    private Set<Position> positions;
    private Biometrics biometrics;
    private BirthInfo birthInfo;
    private Education education;
    private DraftInfo draftInfo;
    private Date debut;

    enum Position {
        POINT_GUARD,
        SHOOTING_GUARD,
        SMALL_FORWARD,
        POWER_FORWARD,
        CENTER
    }

    public void updateInfo(Player updatedPlayer) {
        PlayerName updateName = updatedPlayer.getName();
        this.getName().setFirstName(updateName.getFirstName());
        this.getName().setLastName(updateName.getLastName());
        this.getName().setFullName(updateName.getFullName());
        this.getName().getNicknames().addAll(updateName.getNicknames());

        this.getPositions().addAll(updatedPlayer.getPositions());

        Biometrics updatedBiometrics = updatedPlayer.getBiometrics();
        this.getBiometrics().setHeight(updatedBiometrics.getHeight());
        this.getBiometrics().setWeight(updatedBiometrics.getWeight());
        this.getBiometrics().setShootingHand(updatedBiometrics.getShootingHand());

        BirthInfo updatedBirthInfo = updatedPlayer.getBirthInfo();
        this.getBirthInfo().setBirthday(updatedBirthInfo.getBirthday());
        this.getBirthInfo().getLocation().setCity(updatedBirthInfo.getLocation().getCity());
        this.getBirthInfo().getLocation().setState(updatedBirthInfo.getLocation().getState());
        this.getBirthInfo().getLocation().setCountry(updatedBirthInfo.getLocation().getCountry());

        SchoolInfo updatedCollegeInfo = updatedPlayer.getEducation().getCollege();
        this.getEducation().getCollege().setSchoolName(updatedCollegeInfo.getSchoolName());
        this.getEducation().getCollege().getLocation().setCity(updatedCollegeInfo.getLocation().getCity());
        this.getEducation().getCollege().getLocation().setState(updatedCollegeInfo.getLocation().getState());
        this.getEducation().getCollege().getLocation().setCountry(updatedCollegeInfo.getLocation().getCountry());

        SchoolInfo updatedHighSchoolInfo = updatedPlayer.getEducation().getHighSchool();
        this.getEducation().getHighSchool().setSchoolName(updatedHighSchoolInfo.getSchoolName());
        this.getEducation().getHighSchool().getLocation().setCity(updatedHighSchoolInfo.getLocation().getCity());
        this.getEducation().getHighSchool().getLocation().setState(updatedHighSchoolInfo.getLocation().getState());
        this.getEducation().getHighSchool().getLocation().setCountry(updatedHighSchoolInfo.getLocation().getCountry());

        DraftInfo updatedDraftInfo = updatedPlayer.getDraftInfo();
        this.getDraftInfo().setDate(updatedDraftInfo.getDate());
        this.getDraftInfo().setRound(updatedDraftInfo.getRound());
        this.getDraftInfo().setPosition(updatedDraftInfo.getPosition());
        this.getDraftInfo().setOverallPosition(updatedDraftInfo.getOverallPosition());
        this.getDraftInfo().setTeam(updatedDraftInfo.getTeam());

        this.setDebut(updatedPlayer.getDebut());
    }
}
