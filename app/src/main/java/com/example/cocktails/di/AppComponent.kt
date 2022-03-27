package com.example.cocktails.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component (modules = [CocktailInfoModule::class])
interface AppComponent {


}