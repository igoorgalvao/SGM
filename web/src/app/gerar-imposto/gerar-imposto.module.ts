import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { MessageService } from 'primeng-lts/api';
import { ImpostoService } from '../services/imposto.service';
import { PrimengModule } from '../shared/primeng/primeng.module';
import { GerarImpostoRoutingModule } from './gerar-imposto-routing.module';
import { GerarImpostoComponent } from './gerar-imposto.component';


@NgModule({
  declarations: [
    GerarImpostoComponent,
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    GerarImpostoRoutingModule,

    PrimengModule
  ],
  providers: [MessageService],
})
export class GerarImpostoModule { }
