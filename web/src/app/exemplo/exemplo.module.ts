import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { PrimengModule } from '../shared/primeng/primeng.module';
import { ExemploRoutingModule } from './exemplo-routing.module';
import { ExemploComponent } from './exemplo.component';


@NgModule({
  declarations: [
    ExemploComponent,
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    ExemploRoutingModule,

    PrimengModule
  ],
  providers: [],
})
export class ExemploModule { }
