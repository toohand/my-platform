package com.lefthand.base.bdcode;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

/**
 * Description:大小写处理宏
 * @author hp
 *
 */
public class UpperFirstCharacter implements TemplateDirectiveModel {

    /* (non-Javadoc)
     * @see freemarker.template.TemplateDirectiveModel#execute(freemarker.core.Environment, java.util.Map, freemarker.template.TemplateModel[], freemarker.template.TemplateDirectiveBody)
     */
    @SuppressWarnings("unchecked")
	public void execute(Environment env,
            Map params, TemplateModel[] loopVars,
            TemplateDirectiveBody body)
            throws TemplateException, IOException {
        // Check if no parameters were given:
        if (!params.isEmpty()) {
            throw new TemplateModelException(
                    "This directive doesn't allow parameters.");
        }
        if (loopVars.length != 0) {
                throw new TemplateModelException(
                    "This directive doesn't allow loop variables.");
        }
        
        // If there is non-empty nested content:
        if (body != null) {
            // Executes the nested body. Same as <#nested> in FTL, except
            // that we use our own writer instead of the current output writer.
            body.render(new UpperCaseFilterWriter(env.getOut()));
        } else {
            throw new RuntimeException("missing body");
        }
    }
    
    /**
     * A {@link Writer} that transforms the character stream to upper case
     * and forwards it to another {@link Writer}.
     */ 
    private static class UpperCaseFilterWriter extends Writer {
       
        private final Writer out;
           
        UpperCaseFilterWriter (Writer out) {
            this.out = out;
        }

        /* (non-Javadoc)
         * @see java.io.Writer#write(char[], int, int)
         */
        @Override
		public void write(char[] cbuf, int off, int len)
                throws IOException {
        	cbuf[0] = Character.toUpperCase(cbuf[0]);
        	out.write(String.valueOf(cbuf).trim());
        }

        /* (non-Javadoc)
         * @see java.io.Writer#flush()
         */
        @Override
		public void flush() throws IOException {
            out.flush();
        }

        /* (non-Javadoc)
         * @see java.io.Writer#close()
         */
        @Override
		public void close() throws IOException {
            out.close();
        }
    }

}
