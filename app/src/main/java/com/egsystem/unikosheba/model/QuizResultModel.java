package com.egsystem.unikosheba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class QuizResultModel implements Serializable {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("exam_paper")
    @Expose
    private ExamPaper examPaper;
    @SerializedName("exam_participant")
    @Expose
    private ExamParticipant examParticipant;
    @SerializedName("total_participation")
    @Expose
    private Integer totalParticipation;
    @SerializedName("my_position")
    @Expose
    private Integer myPosition;
    @SerializedName("answer_paper_questions")
    @Expose
    private List<AnswerPaperQuestion> answerPaperQuestions;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ExamPaper getExamPaper() {
        return examPaper;
    }

    public void setExamPaper(ExamPaper examPaper) {
        this.examPaper = examPaper;
    }

    public ExamParticipant getExamParticipant() {
        return examParticipant;
    }

    public void setExamParticipant(ExamParticipant examParticipant) {
        this.examParticipant = examParticipant;
    }

    public Integer getTotalParticipation() {
        return totalParticipation;
    }

    public void setTotalParticipation(Integer totalParticipation) {
        this.totalParticipation = totalParticipation;
    }

    public Integer getMyPosition() {
        return myPosition;
    }

    public void setMyPosition(Integer myPosition) {
        this.myPosition = myPosition;
    }

    public List<AnswerPaperQuestion> getAnswerPaperQuestions() {
        return answerPaperQuestions;
    }

    public void setAnswerPaperQuestions(List<AnswerPaperQuestion> answerPaperQuestions) {
        this.answerPaperQuestions = answerPaperQuestions;
    }


    public class AnswerPaper implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("exam_participant_id")
        @Expose
        private String examParticipantId;
        @SerializedName("question_id")
        @Expose
        private String questionId;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("correct_answer")
        @Expose
        private String correctAnswer;
        @SerializedName("given_answer")
        @Expose
        private Object givenAnswer;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("deleted_at")
        @Expose
        private Object deletedAt;
        @SerializedName("question")
        @Expose
        private Question question;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getExamParticipantId() {
            return examParticipantId;
        }

        public void setExamParticipantId(String examParticipantId) {
            this.examParticipantId = examParticipantId;
        }

        public String getQuestionId() {
            return questionId;
        }

        public void setQuestionId(String questionId) {
            this.questionId = questionId;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCorrectAnswer() {
            return correctAnswer;
        }

        public void setCorrectAnswer(String correctAnswer) {
            this.correctAnswer = correctAnswer;
        }

        public Object getGivenAnswer() {
            return givenAnswer;
        }

        public void setGivenAnswer(Object givenAnswer) {
            this.givenAnswer = givenAnswer;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Object getDeletedAt() {
            return deletedAt;
        }

        public void setDeletedAt(Object deletedAt) {
            this.deletedAt = deletedAt;
        }

        public Question getQuestion() {
            return question;
        }

        public void setQuestion(Question question) {
            this.question = question;
        }

    }

    public class AnswerPaperQuestion implements Serializable {

        @SerializedName("sl")
        @Expose
        private Integer sl;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("option_a")
        @Expose
        private String optionA;
        @SerializedName("option_b")
        @Expose
        private String optionB;
        @SerializedName("option_c")
        @Expose
        private String optionC;
        @SerializedName("option_d")
        @Expose
        private String optionD;
        @SerializedName("correct_answer")
        @Expose
        private String correctAnswer;
        @SerializedName("given_answer")
        @Expose
        private String givenAnswer;

        public Integer getSl() {
            return sl;
        }

        public void setSl(Integer sl) {
            this.sl = sl;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getOptionA() {
            return optionA;
        }

        public void setOptionA(String optionA) {
            this.optionA = optionA;
        }

        public String getOptionB() {
            return optionB;
        }

        public void setOptionB(String optionB) {
            this.optionB = optionB;
        }

        public String getOptionC() {
            return optionC;
        }

        public void setOptionC(String optionC) {
            this.optionC = optionC;
        }

        public String getOptionD() {
            return optionD;
        }

        public void setOptionD(String optionD) {
            this.optionD = optionD;
        }

        public String getCorrectAnswer() {
            return correctAnswer;
        }

        public void setCorrectAnswer(String correctAnswer) {
            this.correctAnswer = correctAnswer;
        }

        public String getGivenAnswer() {
            return givenAnswer;
        }

        public void setGivenAnswer(String givenAnswer) {
            this.givenAnswer = givenAnswer;
        }

    }

    public class ExamPaper implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("subject_id")
        @Expose
        private String subjectId;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("price")
        @Expose
        private String price;
        @SerializedName("date_and_time")
        @Expose
        private String dateAndTime;
        @SerializedName("end_date_and_time")
        @Expose
        private String endDateAndTime;
        @SerializedName("duration")
        @Expose
        private String duration;
        @SerializedName("total_mark")
        @Expose
        private String totalMark;
        @SerializedName("per_question_mark")
        @Expose
        private String perQuestionMark;
        @SerializedName("per_question_negative_mark")
        @Expose
        private String perQuestionNegativeMark;
        @SerializedName("exam_entry_description")
        @Expose
        private Object examEntryDescription;

        @SerializedName("result_publish")
        @Expose
        private String resultPublish;
        @SerializedName("show_correct_answer")
        @Expose
        private String showCorrectAnswer;


        @SerializedName("result_publish_time")
        @Expose
        private String resultPublishTime;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("deleted_at")
        @Expose
        private Object deletedAt;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSubjectId() {
            return subjectId;
        }

        public void setSubjectId(String subjectId) {
            this.subjectId = subjectId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getDateAndTime() {
            return dateAndTime;
        }

        public void setDateAndTime(String dateAndTime) {
            this.dateAndTime = dateAndTime;
        }

        public String getEndDateAndTime() {
            return endDateAndTime;
        }

        public void setEndDateAndTime(String endDateAndTime) {
            this.endDateAndTime = endDateAndTime;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getTotalMark() {
            return totalMark;
        }

        public void setTotalMark(String totalMark) {
            this.totalMark = totalMark;
        }

        public String getPerQuestionMark() {
            return perQuestionMark;
        }

        public void setPerQuestionMark(String perQuestionMark) {
            this.perQuestionMark = perQuestionMark;
        }

        public String getPerQuestionNegativeMark() {
            return perQuestionNegativeMark;
        }

        public void setPerQuestionNegativeMark(String perQuestionNegativeMark) {
            this.perQuestionNegativeMark = perQuestionNegativeMark;
        }

        public Object getExamEntryDescription() {
            return examEntryDescription;
        }

        public void setExamEntryDescription(Object examEntryDescription) {
            this.examEntryDescription = examEntryDescription;
        }

        public String getResultPublish() {
            return resultPublish;
        }

        public void setResultPublish(String resultPublish) {
            this.resultPublish = resultPublish;
        }

        public String getShowCorrectAnswer() {
            return showCorrectAnswer;
        }

        public void setShowCorrectAnswer(String showCorrectAnswer) {
            this.showCorrectAnswer = showCorrectAnswer;
        }

        public String getResultPublishTime() {
            return resultPublishTime;
        }

        public void setResultPublishTime(String resultPublishTime) {
            this.resultPublishTime = resultPublishTime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Object getDeletedAt() {
            return deletedAt;
        }

        public void setDeletedAt(Object deletedAt) {
            this.deletedAt = deletedAt;
        }

    }

    public class ExamParticipant implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("student_id")
        @Expose
        private String studentId;
        @SerializedName("exam_paper_id")
        @Expose
        private String examPaperId;
        @SerializedName("entry_time")
        @Expose
        private String entryTime;
        @SerializedName("submit_time")
        @Expose
        private String submitTime;
        @SerializedName("obtained_marks")
        @Expose
        private String obtainedMarks;
        @SerializedName("negative_marks")
        @Expose
        private String negativeMarks;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("deleted_at")
        @Expose
        private Object deletedAt;
        @SerializedName("answer_papers")
        @Expose
        private List<AnswerPaper> answerPapers;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getStudentId() {
            return studentId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public String getExamPaperId() {
            return examPaperId;
        }

        public void setExamPaperId(String examPaperId) {
            this.examPaperId = examPaperId;
        }

        public String getEntryTime() {
            return entryTime;
        }

        public void setEntryTime(String entryTime) {
            this.entryTime = entryTime;
        }

        public String getSubmitTime() {
            return submitTime;
        }

        public void setSubmitTime(String submitTime) {
            this.submitTime = submitTime;
        }

        public String getObtainedMarks() {
            return obtainedMarks;
        }

        public void setObtainedMarks(String obtainedMarks) {
            this.obtainedMarks = obtainedMarks;
        }

        public String getNegativeMarks() {
            return negativeMarks;
        }

        public void setNegativeMarks(String negativeMarks) {
            this.negativeMarks = negativeMarks;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Object getDeletedAt() {
            return deletedAt;
        }

        public void setDeletedAt(Object deletedAt) {
            this.deletedAt = deletedAt;
        }

        public List<AnswerPaper> getAnswerPapers() {
            return answerPapers;
        }

        public void setAnswerPapers(List<AnswerPaper> answerPapers) {
            this.answerPapers = answerPapers;
        }

    }

    public class Question implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("subject_id")
        @Expose
        private String subjectId;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("option_a")
        @Expose
        private String optionA;
        @SerializedName("option_b")
        @Expose
        private String optionB;
        @SerializedName("option_c")
        @Expose
        private String optionC;
        @SerializedName("option_d")
        @Expose
        private String optionD;
        @SerializedName("option_e")
        @Expose
        private Object optionE;
        @SerializedName("correct_answer")
        @Expose
        private String correctAnswer;
        @SerializedName("reference")
        @Expose
        private String reference;
        @SerializedName("description")
        @Expose
        private Object description;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("deleted_at")
        @Expose
        private Object deletedAt;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getSubjectId() {
            return subjectId;
        }

        public void setSubjectId(String subjectId) {
            this.subjectId = subjectId;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getOptionA() {
            return optionA;
        }

        public void setOptionA(String optionA) {
            this.optionA = optionA;
        }

        public String getOptionB() {
            return optionB;
        }

        public void setOptionB(String optionB) {
            this.optionB = optionB;
        }

        public String getOptionC() {
            return optionC;
        }

        public void setOptionC(String optionC) {
            this.optionC = optionC;
        }

        public String getOptionD() {
            return optionD;
        }

        public void setOptionD(String optionD) {
            this.optionD = optionD;
        }

        public Object getOptionE() {
            return optionE;
        }

        public void setOptionE(Object optionE) {
            this.optionE = optionE;
        }

        public String getCorrectAnswer() {
            return correctAnswer;
        }

        public void setCorrectAnswer(String correctAnswer) {
            this.correctAnswer = correctAnswer;
        }

        public String getReference() {
            return reference;
        }

        public void setReference(String reference) {
            this.reference = reference;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Object getDeletedAt() {
            return deletedAt;
        }

        public void setDeletedAt(Object deletedAt) {
            this.deletedAt = deletedAt;
        }

    }


}