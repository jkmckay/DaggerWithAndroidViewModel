#DaggerWithAndroidViewModel

The following presumes a usage of Android Architecture components in addition to Dagger2

#### Modules:

Module classes denote what it is you're injecting and are essentially made up of a number of  "provide methods" that create and return the dependency to be injected. To create a module class one simply annotates with `@Module` or if submodules are to be included, you can include them like so:

```kotlin
@Module(includes = [SubModule::class])
```

#### Provides:

The `@Provide` annotation marks a method as one that satisfies the dependency being provided. For example, the following provides a  `PaymentViewModelDelegate`:

```kotlin
@Module(includes = [RepositoryModule::class]) //submodule

class ViewModelDelegateModule {

    @Provides
    internal fun providePaymentViewModelDelegate(basketRepo: BasketRepositoryInterface, paymentRepo: PaymentRepositoryInterface)
            : SelectCardViewModelDelegateInterface = SelectCardViewModelDelegateImpl(basketRepo, paymentRepo)

}
```

The `providePaymentViewModelDelegate` method takes a `basketRepo` and `paymentRepo` as parameters. Both of which has their own provider methods in the `RepositoryModule` that is included as a submodule to the above. 

The `RepositoryModule` is as follows.

```kotlin
 @Module
class RepositoryModule {

    @Provides
    @Singleton //provider methods can be marked as singletons.
    internal fun providePaymentRepository(apiClient: ApiClientInterface)
            : PaymentRepositoryInterface = PaymentRepository(apiClient)
    
    @Provides
    @Singleton
    internal fun providesBasketRepository(applicationContext: Context, api: ApiClientInterface)
            : BasketRepositoryInterface = BasketRepository(applicationContext, api)
}
```

#### Components:

The `@Component` annotation is applied to interfaces to create groups of related dependencies. That is to say a component is made up of 1..* modules or components. For example one might have a CreatureComponent that may include a WarmBloodedComponent which may include Avian and Mammal modules as well as a ColdBloodedComponent that may include a Reptile and Amphibian Modules.



## Architecture Component specific implementation

