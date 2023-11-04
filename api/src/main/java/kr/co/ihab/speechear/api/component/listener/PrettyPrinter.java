package kr.co.ihab.speechear.api.component.listener;

import org.jooq.DSLContext;
import org.jooq.ExecuteContext;
import org.jooq.ExecuteListener;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;

public class PrettyPrinter implements ExecuteListener {
    @Override
    public void executeStart(ExecuteContext ctx) {
        DSLContext create = DSL.using(ctx.dialect(),
                new Settings().withRenderFormatted(true));

        if (ctx.query() != null) {
            System.out.println(create.renderInlined(ctx.query()));
        }

        else if (ctx.routine() != null) {
            System.out.println(create.renderInlined(ctx.routine()));
        }
    }
}
