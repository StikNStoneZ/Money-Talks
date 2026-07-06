package com.example.demo;

import org.springframework.web.bind.annotation.*;
import com.example.demo.finance.*;
@CrossOrigin
@RestController
@RequestMapping("/simulate")
public class SimulationController {

    @PostMapping
    public ResultData simulate(@RequestBody InputData input) {

        User user = new User(
                input.income,
                input.expenses,
                input.totalMonths,
                input.investmentRate
        );

        Scenario smart = new SmartScenario(input.reductionRate);
        Scenario normal = new NormalScenario();
        Scenario yolo = new YoloScenario(input.increaseRate);

        SimulationEngine engine = new SimulationEngine();

        ResultData result = new ResultData();

        // Simulation
        result.smart = engine.simulate(user, smart, input.inflationRate);
        result.normal = engine.simulate(user, normal, input.inflationRate);
        result.yolo = engine.simulate(user, yolo, input.inflationRate);

        // Real value
        result.smartReal = engine.adjustForInflation(result.smart, input.totalMonths, input.inflationRate);
        result.normalReal = engine.adjustForInflation(result.normal, input.totalMonths, input.inflationRate);
        result.yoloReal = engine.adjustForInflation(result.yolo, input.totalMonths, input.inflationRate);

        // Goal time
        result.smartMonths = engine.monthsToReachGoal(user, smart, input.goal, input.inflationRate);
        result.normalMonths = engine.monthsToReachGoal(user, normal, input.goal, input.inflationRate);
        result.yoloMonths = engine.monthsToReachGoal(user, yolo, input.goal, input.inflationRate);
        System.out.println("Smart = " + result.smart);
        System.out.println("Normal = " + result.normal);
        System.out.println("Yolo = " + result.yolo);
        return result;
    }
}