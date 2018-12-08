package nl.mwensveen.adventofcode.year_2018.day_7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StepOrderer {

    private Map<String, Step> stepMap;

    public StepOrderer(List<String> input) {
        stepMap = new HashMap<>();
        input.forEach(line -> {
            StepExtractor extractor = new StepExtractor(line);
            Step afterStep = getOrCreateStep(stepMap, extractor.getAfter());
            Step beforeStep = getOrCreateStep(stepMap, extractor.getBefore());
            afterStep.getBeforeSteps().add(beforeStep);
        });
    }

    private Step getOrCreateStep(Map<String, Step> stepMap, String stepName) {
        Step step = stepMap.get(stepName);
        if (step == null) {
            step = new Step(stepName);
            stepMap.put(stepName, step);
        }
        return step;
    }

    public String determineOrder() {
        StringBuilder orderOfSteps = new StringBuilder();
        Optional<Step> nextStep = findNextStep();

        while (nextStep.isPresent()) {
            Step step = nextStep.get();
            step.setDone();
            orderOfSteps.append(step.getName());
            nextStep = findNextStep();
        }
        return orderOfSteps.toString();
    }

    private Optional<Step> findNextStep() {
        return stepMap.values().stream().filter(Step::isReadyForExecution).sorted((s1, s2) -> s1.getName().compareTo(s2.getName())).findFirst();
    }

    public int determineOrderWithExecutionTime(int defaultStepTime, int numberOfWorkers) {
        int executionTime = 0;
        Step[] workers = new Step[numberOfWorkers];

        Optional<Step> nextStep = findNextStep();
        workers[0] = nextStep.get();
        workers[0].startExecution(defaultStepTime);

        while (!allWorkersDone(workers)) {
            executionTime++;
            for (Step step : workers) {
                if (step != null) {
                    step.executionSecondPassed();
                }
            }
            for (int i = 0; i < workers.length; i++) {
                if (workers[i] == null || (workers[i].isDone())) {
                    nextStep = findNextStep();
                    workers[i] = nextStep.orElse(null);
                    if (nextStep.isPresent()) {
                        nextStep.get().startExecution(defaultStepTime);
                    }
                }
            }
        }
        return executionTime;
    }

    private boolean allWorkersDone(Step[] workers) {
        for (Step step : workers) {
            if (step != null) {
                return false;
            }
        }
        return true;
    }
}
