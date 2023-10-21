package com.example.university.entity;

public class Speciality {
    private Integer id;
    private String specialityName;
    private String specialityCode;
    private String curriculumCode;
    private String description;
    private String curriculumLink;
    private Faculty faculty;

    public Speciality(Integer id, String specialityName, String specialityCode, String curriculumCode, String description, String curriculumLink) {
        this.id = id;
        this.specialityName = specialityName;
        this.specialityCode = specialityCode;
        this.curriculumCode = curriculumCode;
        this.description = description;
        this.curriculumLink = curriculumLink;
    }

    public Speciality(String specialityName, String specialityCode, String curriculumCode, String description, String curriculumLink) {
        this.id = null;
        this.specialityName = specialityName;
        this.specialityCode = specialityCode;
        this.curriculumCode = curriculumCode;
        this.description = description;
        this.curriculumLink = curriculumLink;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    public String getSpecialityCode() {
        return specialityCode;
    }

    public void setSpecialityCode(String specialityCode) {
        this.specialityCode = specialityCode;
    }

    public String getCurriculumCode() {
        return curriculumCode;
    }

    public void setCurriculumCode(String curriculumCode) {
        this.curriculumCode = curriculumCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurriculumLink() {
        return curriculumLink;
    }

    public void setCurriculumLink(String curriculumLink) {
        this.curriculumLink = curriculumLink;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
