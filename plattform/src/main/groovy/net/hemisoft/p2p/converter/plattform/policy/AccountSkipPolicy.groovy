package net.hemisoft.p2p.converter.plattform.policy

import org.springframework.batch.core.step.skip.SkipLimitExceededException
import org.springframework.batch.core.step.skip.SkipPolicy

import net.hemisoft.p2p.converter.plattform.exception.SkipableException

public class AccountSkipPolicy implements SkipPolicy {

    @Override
    public boolean shouldSkip(Throwable t, int skipCount) throws SkipLimitExceededException {
        if (SkipableException.class.isInstance(t)) return true
                                                   return false
    }

}
