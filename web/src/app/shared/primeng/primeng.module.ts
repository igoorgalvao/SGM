import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ButtonModule } from 'primeng-lts/button';
import { InputTextModule } from 'primeng-lts/inputtext';
import { CheckboxModule } from 'primeng-lts/checkbox';
import { RadioButtonModule } from 'primeng-lts/radiobutton';
import { PanelModule } from 'primeng-lts/panel';
import { DropdownModule } from 'primeng-lts/dropdown';
import { RippleModule } from 'primeng-lts/ripple';
import { InputTextareaModule } from 'primeng-lts/inputtextarea';
import { TabViewModule } from 'primeng-lts/tabview';
import { FormsModule } from '@angular/forms';



const PRIMENG_COMPONENTS = [
    ButtonModule,
    InputTextModule,
    InputTextModule,
    ButtonModule,
    CheckboxModule,
    RadioButtonModule,
    PanelModule,
    DropdownModule,
    InputTextareaModule,
    RippleModule,
    TabViewModule,
];

@NgModule({
    declarations: [],
    imports: [
        CommonModule,
        FormsModule,
        PRIMENG_COMPONENTS
    ],
    exports: [
        PRIMENG_COMPONENTS
    ]
})
export class PrimengModule {
}
