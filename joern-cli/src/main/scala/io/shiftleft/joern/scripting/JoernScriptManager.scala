package io.shiftleft.joern.scripting

import io.shiftleft.codepropertygraph.Cpg
import io.shiftleft.console.scripting.ScriptManager

class JoernScriptManager extends ScriptManager(JoernAmmoniteExecutor) {

  implicit class CpgScriptRunner(cpg: Cpg) {

    /**
      * Run an arbitrary script over this CPG.
      *
      * @param name The name of the script to run.
      * @return The result of running the script against this CPG.
      */
    def runScript(name: String): Any =
      runScript(name, Map.empty)

    /**
      * Run an arbitrary script over this CPG with parameters.
      *
      * @param name The name of the script to run.
      * @param parameters The parameters to pass to the script.
      * @return The result of running the script against this CPG.
      */
    def runScript(name: String, parameters: Map[String, String]): Any =
      JoernScriptManager.this.runScript(name, parameters, cpg)
  }
}
