package ru.system.OLSystem.olympiad.objects;

public class TaskDemo {

    private String title;
    private String description;
    private String inputData;
    private String outputData;

    private TaskDemo(Builder builder) {
        this.title = builder.title;
        this.description = builder.description;
        this.inputData = builder.inputData;
        this.outputData = builder.outputData;
    }

    public static class Builder {

        private String title;
        private String description;
        private String inputData;
        private String outputData;

        public Builder() { }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setInputData(String inputData) {
            this.inputData = inputData;
            return this;
        }

        public Builder setOutputData(String outputData) {
            this.outputData = outputData;
            return this;
        }

        public TaskDemo build() {
            return new TaskDemo(this);
        }

    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getInputData() {
        return inputData;
    }

    public String getOutputData() {
        return outputData;
    }

}