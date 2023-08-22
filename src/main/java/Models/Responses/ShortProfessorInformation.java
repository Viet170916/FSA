package Models.Responses;

import Models.Entities.Professor;

public class ShortProfessorInformation{
  private String url = "professor/detail-information?id=";
  private String code;

  public ShortProfessorInformation(Professor professor){
    this.url = url + professor.getId();
    this.code = professor.getCode();
  }

  public ShortProfessorInformation(ProfessorResponse professor){
    this.url = url + professor.getId();
    this.code = professor.getCode();
  }
}
