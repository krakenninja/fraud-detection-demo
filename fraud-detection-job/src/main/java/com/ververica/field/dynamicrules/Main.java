/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ververica.field.dynamicrules;

import static com.ververica.field.config.Parameters.BOOL_PARAMS;
import static com.ververica.field.config.Parameters.INT_PARAMS;
import static com.ververica.field.config.Parameters.STRING_PARAMS;

import com.ververica.field.config.Config;
import com.ververica.field.config.Parameters;
import lombok.extern.slf4j.Slf4j;
import org.apache.flink.api.java.utils.ParameterTool;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Main implements CommandLineRunner {
    
  public static void main(String[] args) throws Exception {
    SpringApplication.run(
        Main.class, 
        args
    );

  }
  
    private final RulesEvaluator rulesEvaluator;

    public Main(RulesEvaluator rulesEvaluator) {
        this.rulesEvaluator = rulesEvaluator;
    }

    @Override
    public void run(String... args) throws Exception {
      log.info(
        "Running rules evaluator `{}` type ...",
        rulesEvaluator.getClass().getName()
      );
      ParameterTool tool = ParameterTool.fromArgs(args);
      Parameters inputParams = new Parameters(tool);
      Config config = new Config(inputParams, STRING_PARAMS, INT_PARAMS, BOOL_PARAMS);
      rulesEvaluator.setConfig(
        config
      ).run();
      log.info(
        "Rules evaluator `{}` type RUN OK",
        rulesEvaluator.getClass().getName()
      );
    }
}
