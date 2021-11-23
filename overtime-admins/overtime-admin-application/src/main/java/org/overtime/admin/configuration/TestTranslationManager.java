package org.overtime.admin.configuration;

import io.r2dbc.spi.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;
import org.springframework.transaction.*;
import org.springframework.transaction.reactive.GenericReactiveTransaction;
import org.springframework.transaction.reactive.TransactionSynchronizationManager;
import reactor.core.publisher.Mono;

/**
 * @author ForteScarlet
 */
@Slf4j
public class TestTranslationManager extends R2dbcTransactionManager implements ReactiveTransactionManager {

    /**
     * Create a new {@code R2dbcTransactionManager} instance.
     *
     * @param connectionFactory the R2DBC ConnectionFactory to manage transactions for
     */
    public TestTranslationManager(ConnectionFactory connectionFactory) {
        super(connectionFactory);
    }

    /**
     * Return a transaction object for the current transaction state.
     * <p>The returned object will usually be specific to the concrete transaction
     * manager implementation, carrying corresponding transaction state in a
     * modifiable fashion. This object will be passed into the other template
     * methods (e.g. doBegin and doCommit), either directly or as part of a
     * DefaultReactiveTransactionStatus instance.
     * <p>The returned object should contain information about any existing
     * transaction, that is, a transaction that has already started before the
     * current {@code getTransaction} call on the transaction manager.
     * Consequently, a {@code doGetTransaction} implementation will usually
     * look for an existing transaction and store corresponding state in the
     * returned transaction object.
     *
     * @param synchronizationManager the synchronization manager bound to the current transaction
     * @return the current transaction object
     * @throws CannotCreateTransactionException if transaction support is not available
     * @throws TransactionException             in case of lookup or system errors
     * @see #doBegin
     * @see #doCommit
     * @see #doRollback
     * @see GenericReactiveTransaction#getTransaction
     */
    @Override
    protected @NotNull Object doGetTransaction(@NotNull TransactionSynchronizationManager synchronizationManager) throws TransactionException {
        log.debug("========== do get transaction ==========");
        log.debug("synchronizationManager = {} ", synchronizationManager);

        return super.doGetTransaction(synchronizationManager);
    }

    /**
     * Begin a new transaction with semantics according to the given transaction
     * definition. Does not have to care about applying the propagation behavior,
     * as this has already been handled by this abstract manager.
     * <p>This method gets called when the transaction manager has decided to actually
     * start a new transaction. Either there wasn't any transaction before, or the
     * previous transaction has been suspended.
     * <p>A special scenario is a nested transaction: This method will be called to
     * start a nested transaction when necessary. In such a context, there will be an
     * active transaction: The implementation of this method has to detect this and
     * start an appropriate nested transaction.
     *
     * @param synchronizationManager the synchronization manager bound to the new transaction
     * @param transaction            the transaction object returned by {@code doGetTransaction}
     * @param definition             a TransactionDefinition instance, describing propagation
     *                               behavior, isolation level, read-only flag, timeout, and transaction name
     * @throws TransactionException                   in case of creation or system errors
     * @throws NestedTransactionNotSupportedException if the underlying transaction does not support nesting (e.g. through savepoints)
     */
    @Override
    protected @NotNull Mono<Void> doBegin(@NotNull TransactionSynchronizationManager synchronizationManager, @NotNull Object transaction, @NotNull TransactionDefinition definition) throws TransactionException {
        log.debug("========== do begin ==========");
        log.debug("synchronizationManager = {}", synchronizationManager);
        log.debug("transaction = {}", transaction);
        log.debug("definition = {}", definition);

        return super.doBegin(synchronizationManager, transaction, definition);
    }

    /**
     * Perform an actual commit of the given transaction.
     * <p>An implementation does not need to check the "new transaction" flag
     * or the rollback-only flag; this will already have been handled before.
     * Usually, a straight commit will be performed on the transaction object
     * contained in the passed-in status.
     *
     * @param synchronizationManager the synchronization manager bound to the current transaction
     * @param status                 the status representation of the transaction
     * @throws TransactionException in case of commit or system errors
     * @see GenericReactiveTransaction#getTransaction
     */
    @Override
    protected @NotNull Mono<Void> doCommit(@NotNull TransactionSynchronizationManager synchronizationManager, @NotNull GenericReactiveTransaction status) throws TransactionException {
        log.debug("========== do commit ==========");
        log.debug("synchronizationManager = {}", synchronizationManager);
        log.debug("status = {}", status);

        return super.doCommit(synchronizationManager, status);
    }

    /**
     * Perform an actual rollback of the given transaction.
     * <p>An implementation does not need to check the "new transaction" flag;
     * this will already have been handled before. Usually, a straight rollback
     * will be performed on the transaction object contained in the passed-in status.
     *
     * @param synchronizationManager the synchronization manager bound to the current transaction
     * @param status                 the status representation of the transaction
     * @throws TransactionException in case of system errors
     * @see GenericReactiveTransaction#getTransaction
     */
    @Override
    protected @NotNull Mono<Void> doRollback(@NotNull TransactionSynchronizationManager synchronizationManager, @NotNull GenericReactiveTransaction status) throws TransactionException {
        log.debug("========== do rollback ==========");
        log.debug("synchronizationManager = {}", synchronizationManager);
        log.debug("status = {}", status);

        return super.doRollback(synchronizationManager, status);
    }
}
