package br.com.youthquake.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Component
@Table(name = "tbl_questions")
public class Questions {
	
	public Questions() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_question")
	private long idQuestion;
	
	@JsonProperty
	@Column(name="question")
	private String question;
	
	@JsonProperty
	@Column(name="first_awnser")
	private String firstOption;
	
	@JsonProperty
	@Column(name="second_awnser")
	private String secondOption;
	
	@JsonProperty
	@Column(name="third_awnser")
	private String thirdOption;
	
	@JsonProperty
	@Column(name="fourth_awnser")
	private String fourthOption;
	
	@JsonProperty
	@Column(name="correct_awnser")
	private String rightAnswer;
	
	public Questions(String question, String firstOption, String secondOption, String thirdOption,
					String fourthOption, String rightAnswer ) {
		this.question = question;
		this.firstOption = firstOption; 
		this.secondOption = secondOption;
		this.thirdOption = thirdOption;
		this.fourthOption = fourthOption;
		this.rightAnswer = rightAnswer;
	}

	public long getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(long idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getFirstOption() {
		return firstOption;
	}

	public void setFirstOption(String firstOption) {
		this.firstOption = firstOption;
	}

	public String getSecondOption() {
		return secondOption;
	}

	public void setSecondOption(String secondOption) {
		this.secondOption = secondOption;
	}

	public String getThirdOption() {
		return thirdOption;
	}

	public void setThirdOption(String thirdOption) {
		this.thirdOption = thirdOption;
	}

	public String getFourthOption() {
		return fourthOption;
	}

	public void setFourthOption(String fourthOption) {
		this.fourthOption = fourthOption;
	}

	public String getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}
}
