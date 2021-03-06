// This is a generated file. Not intended for manual editing.
package intellij.haskell.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import intellij.haskell.psi.HaskellBracketExpression;
import intellij.haskell.psi.HaskellExpression;
import intellij.haskell.psi.HaskellVisitor;
import org.jetbrains.annotations.NotNull;

public class HaskellBracketExpressionImpl extends HaskellExpressionImpl implements HaskellBracketExpression {

    public HaskellBracketExpressionImpl(ASTNode node) {
        super(node);
    }

    @Override
    public void accept(@NotNull HaskellVisitor visitor) {
        visitor.visitBracketExpression(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof HaskellVisitor) accept((HaskellVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public HaskellExpression getExpression() {
        return notNullChild(PsiTreeUtil.getChildOfType(this, HaskellExpression.class));
    }

}
