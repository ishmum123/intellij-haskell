package intellij.haskell.action.HaskellTools

import com.intellij.openapi.actionSystem.{AnAction, AnActionEvent}
import intellij.haskell.action.{ActionContext, ActionUtil}
import intellij.haskell.external.component.{HaskellToolsComponent, StackProjectManager}
import intellij.haskell.psi.HaskellPsiUtil
import intellij.haskell.util.{HaskellEditorUtil, HaskellFileUtil}

class GenerateExportsAction extends AnAction {

  override def update(actionEvent: AnActionEvent): Unit = {
    HaskellEditorUtil.enableExternalAction(actionEvent, StackProjectManager.isHaskellToolsAvailable)
  }

  override def actionPerformed(e: AnActionEvent): Unit = {
    val project = e.getProject

    HaskellToolsComponent.checkResolverForAction(project, e, (actionEvent) => {
      ActionUtil.findActionContext(actionEvent).foreach {
        case ActionContext(psiFile, _, _, _) =>
          HaskellFileUtil.saveFile(psiFile)

          HaskellPsiUtil.findModuleName(psiFile).foreach(moduleName => {
            HaskellToolsComponent.generateExports(project, psiFile, moduleName)
          })
      }
    })
  }
}