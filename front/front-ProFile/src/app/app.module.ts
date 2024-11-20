import { NgModule } from '@angular/core';

import { BrowserModule } from '@angular/platform-browser';
import { NbEvaIconsModule } from '@nebular/eva-icons';
import { NbButtonModule, NbCardModule, NbFormFieldModule, NbIconModule, NbInputModule, NbLayoutModule, NbMenuModule, NbSidebarModule, NbThemeModule } from '@nebular/theme';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ExperienceFormComponent } from './form/experience-form/experience-form.component';
import { PerfilFormComponent } from './form/perfil-form/perfil-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    PerfilFormComponent,
    ExperienceFormComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NbThemeModule.forRoot({ name: 'default' }),
    NbLayoutModule,
    NbMenuModule,
    NbCardModule,
    NbSidebarModule.forRoot(),
    NbButtonModule,
    NbIconModule,
    NbEvaIconsModule,
    NbInputModule,
    NbFormFieldModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
