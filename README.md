# DaggerWithAndroidViewModel

The following presumes a familiarity of Android Architecture components in addition to Dagger2



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

#### Binds

The `@Binds` annotation is a replacement for `@Provides`. You use this instead of `@provides`
when you do not need to specify the exact implementation. The Binds method can only have a single parameter whose type is assignable to the return type. It essentially returns the injected parameter.

#### Components:

The `@Component` annotation is applied to interfaces to create groups of related dependencies. That is to say a component is made up of 1..* modules or components. For example one might have a CreatureComponent that may include a WarmBloodedComponent which may include Avian and Mammal modules as well as a ColdBloodedComponent that may include a Reptile and Amphibian Modules.

## Android specific implementation

#### AndroidInjector

Performs the members-injection for concrete "core Android classes" such as Activities, Fragments, etc.

#### AndroidInjector.Factory

Creates AndroidInjectors for concrete "core Android classes" such as Activities, Fragments, etc.

#### DispatchingAndroidInjector

DispatchingAndroidInjector is used to provide dependencies for Android components such as Activities and fragments
that are instantiated by the Android framework and not by Dagger.
It works this out via a mapping of each concrete classes to a specific `AndroidInjector` of that class. This mapping is passed  to a `AndroidInjector.Factory` which the `DispatchingAndroidInjector` relies upon.

#### ContributesAndroidInjector

The `@ContributesAndroidInjector` annotation is used to generate an `AndroidInjector` for the method's return type. The `AndroidInjector` is implemented with a Subcomponent and will be a child of the module's component.

For example if one is providing a `HomeActivity` as part of an `ActivityModule`, which is part of a `AppComponent`. Using `@ContributesAndroidInjector` will net the following:

* AppComponent : `Component`
  * AndroidInjectorSubComponent : `SubComponent`
    * HomeActivity's AndroidInjector: `AndroidInjector`
  * ActivityModule: `Module`
    * HomeActivity: `Activity`



## Why is this better?

#### Classes don't have to care about how they are injected.

One of the core principles of Dependency Injection is that "a class shouldn’t know anything about how it is injected". Which, with previous implementations of Dagger was a principle that wasn't followed as strictly. For example, the below was a common pattern.

```kotlin
  (application as MyApplication)
        .getAppComponent()
        .mainActivity( MainActivityModule(userId))
        .build()
        .inject(this)
```

Now dependencies can be injected without caring how they are satisfied as this work is now kept out of the dependent classes.

#### Less boilerplate

- Dagger-Android requires you to create separate sub-components for you Android core classes (activities,fragments,services, etc). `@ContributesAndroidInjector` removes that boilerplate.

**Previously**:

- AppComponent
  - AppModule
    - MainActivitySubComponent
      - MainActivityModule
    - DetailActivitySubComponent
      - DetailActivityModule
  - ActivityModule
    - MainActivity
    - DetailActivity
  - AndroidInjectionModule

**With `@ContributesAndroidInjector`:**

- AppComponent
  - AppModule
  - ActivityModule
    - MainActivityModule (annotated with @ContributesAndroidInjecto)
    - DetailActivityModule (annotated with @ContributesAndroidInjecto)
  - AndroidInjectionModule

Additionally Using `DaggerApplication` and its associated classes further removes the need from boilerplate, especially from the Application class. as can be seen in the `TODO` build variant.

### Sources 

#### [Mert Şimşek](https://medium.com/@iammert/new-android-injector-with-dagger-2-part-1-8baa60152abe)

#### [Dagger & Android](https://google.github.io/dagger/android.html)

#### [Dagger Dependency Injection API](https://google.github.io/dagger/api/2.12/overview-summary.html)

